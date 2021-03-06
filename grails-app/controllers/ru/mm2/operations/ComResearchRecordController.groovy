/*
 * ru.mm2.operations is an application for consultations and operations managing.
 * Copyright (c) 2014 Aleksei Khitevi (Хитёв Алексей Юрьевич), Guilnara Gamidova (Гюльнара Гамидова Вилаятовна).
 *
 * This file is part of ru.mm2.operations
 *
 * ru.mm2.operations is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * ru.mm2.operations is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
*/

package ru.mm2.operations

import org.springframework.security.access.annotation.Secured

import java.text.DateFormat
import java.text.SimpleDateFormat

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ComResearchRecordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ComResearchRecord.list(params), model: [comResearchRecordInstanceCount: ComResearchRecord.count()]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def show(ComResearchRecord comResearchRecordInstance) {
        respond comResearchRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def create() {
        DateFormat dateFormat
        dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", new Locale("en","EN"))
        Date date = dateFormat.parse(params.date_time);
        List<ComResearchRecord> comResearchRecord = ComResearchRecord.findAllByDate_timeBetween((date-1),date)
        respond comResearchRecord, model: [comResearchRecordInstanceCount: ComResearchRecord.count(), date:date]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def save(ComResearchRecord comResearchRecordInstance) {
        if (comResearchRecordInstance == null) {
            notFound()
            return
        }

        if (comResearchRecordInstance.hasErrors()) {
            respond comResearchRecordInstance.errors, view: 'create'
            return
        }

        comResearchRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'comResearchRecordInstance.label', default: 'ComResearchRecord'), comResearchRecordInstance.id])
                redirect comResearchRecordInstance
            }
            '*' { respond comResearchRecordInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def edit(ComResearchRecord comResearchRecordInstance) {
        respond comResearchRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def update(ComResearchRecord comResearchRecordInstance) {
        if (comResearchRecordInstance == null) {
            notFound()
            return
        }

        if (comResearchRecordInstance.hasErrors()) {
            respond comResearchRecordInstance.errors, view: 'edit'
            return
        }

        comResearchRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ComResearchRecord.label', default: 'ComResearchRecord'), comResearchRecordInstance.id])
                redirect comResearchRecordInstance
            }
            '*' { respond comResearchRecordInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def delete(ComResearchRecord comResearchRecordInstance) {

        if (comResearchRecordInstance == null) {
            notFound()
            return
        }

        comResearchRecordInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ComResearchRecord.label', default: 'ComResearchRecord'), comResearchRecordInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'comResearchRecordInstance.label', default: 'ComResearchRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def static isSanday(Date date){
        SimpleDateFormat df = new SimpleDateFormat( "dd/MM/yy" );
        df.applyPattern( "EEE" );
        String dayOfWeek = df.format( date )
        if(dayOfWeek=="Вс"){
            return true
        }else{
            return false
        }
    }

}
