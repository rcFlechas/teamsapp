package com.rcflechas.teamsapp.mappers

interface EntityMapper <in A, out B> {

    fun toEntity() : B
    fun List<A>.toListEntity() : List<B>
}