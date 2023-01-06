package com.dgsw.cns.global.mapper;

public interface Mapper<Domain, Entity> {

    Entity domainToEntity(Domain domain);

    Domain entityToEntity(Entity entity);

}
