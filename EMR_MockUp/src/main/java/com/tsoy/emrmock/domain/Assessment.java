package com.tsoy.emrmock.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Assessment {

    /**
     */
    private String VitalSigns;

    /**
     */
    private String CardioSystem;

    /**
     */
    private String DigestiveSystem;

    /**
     */
    private String EndocrineSystem;

    /**
     */
    private String UrinarySystem;

    /**
     */
    private String MuscularSystem;

    /**
     */
    private String NervousSystem;

    /**
     */
    private String RespiratorySystem;

    /**
     */
    private String Behavior;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date CreatedDate;
}
