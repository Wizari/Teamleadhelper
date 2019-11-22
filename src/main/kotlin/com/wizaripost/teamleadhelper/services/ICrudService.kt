package com.wizaripost.teamleadhelper.services

interface ICrudService<ID, T> {

    /**
     * Get a DTO object by Id
     *
     * @param id entity id
     * @return
     */
    fun getOne(id: ID): T

    /**
     * Update or create (if id is null)
     *
     * @param
     * @return updated DTO object
     */
    fun save(t: T): T
}