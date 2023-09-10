package api3.plugin

import grails.gorm.transactions.Transactional

@Transactional
class LogService {

    def salvarLog(String descricao) {
        Map retorno = [success: true]

        Log log = new Log()
        log.data = LocalDate.now()
        log.descricao = descricao

        if (!log.validate()) {
            retorno.success = false
            retorno.errors = log.errors
            return retorno
        }

        log.save(flush: true)

        retorno.registro = getShowRecord(log)

        return retorno
    }

    private Map getShowRecord(Log log) {
        return [
                id: log.id,
                data: log.data,
                descricao: log.descricao
        ]
    }
}