package com.rcflechas.teamsapp.mappers

interface ResponseMapper <in A, out B> {

    fun toResponse() : B
    fun List<A>.toListResponse() : List<B>
}