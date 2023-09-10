package api3.plugin

import grails.gorm.annotation.Entity

import java.time.LocalDate

@Entity
class Log {
    LocalDate data
    String descricao

    static constraints = {
        data(nullable: false)
        descricao(nullable: false, maxSize: 1000)
    }
}