package ru.mm2.operations

class SecUser {

    transient springSecurityService

    String fullName
    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static transients = ['springSecurityService']

    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    static mapping = {
        password column: '`password`'
    }

    Set<SecRole> getAuthorities() {
        SecUserSecRole.findAllBySecUser(this).collect { it.secRole } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    def toString = { "${fullName}" }

    def encodeAsHTML(){
        "${fullName}"
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }
}
