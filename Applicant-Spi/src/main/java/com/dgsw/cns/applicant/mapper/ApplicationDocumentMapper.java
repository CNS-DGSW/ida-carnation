package com.dgsw.cns.applicant.mapper;

import com.dgsw.cns.applicant.domain.ApplicationDocument;
import com.dgsw.cns.applicant.domain.ApplicationDocumentEntity;
import com.dgsw.cns.global.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDocumentMapper implements Mapper<ApplicationDocument, ApplicationDocumentEntity> {
    @Override
    public ApplicationDocumentEntity domainToEntity(ApplicationDocument domain) {
        return ApplicationDocumentEntity.builder()
                .introduction(domain.getIntroduction())
                .plan(domain.getPlan())
                .picture(domain.getPicture())
                .build();
    }

    @Override
    public ApplicationDocument entityToDomain(ApplicationDocumentEntity entity) {
        return ApplicationDocument.builder()
                .introduction(entity.getIntroduction())
                .plan(entity.getPlan())
                .picture(entity.getPicture())
                .build();
    }
}
