package com.diploma.demo.archive.owner;

import com.diploma.demo.core.landplot.Address;
import com.diploma.demo.core.revinfo.RevisionEntity;
import com.diploma.demo.core.stateregistration.StateRegistration;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "owner_aud")
@NoArgsConstructor
public class OwnerArchive {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "rev")
    private int rev;

    @NonNull
    @NotEmpty
    @Column(name = "revtype")
    private short revtype;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="rev")
    private RevisionEntity revisionEntity;


    @Column(name = "id")
    private Long id;

    @Column(name ="type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name="registration_date")
    private LocalDate registrationDate;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name ="doc_type")
    private String docType;

    @Column(name="doc_n")
    private String docN;

    @OneToOne
    @JoinColumn(name="owner_id")
    private StateRegistration docRegistration;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Embedded
    private Address address;

    @AttributeOverrides({
            @AttributeOverride(name = "region", column = @Column(name = "post_region")),
            @AttributeOverride(name = "city", column = @Column(name = "post_city")),
            @AttributeOverride(name = "street", column = @Column(name = "post_street")),
            @AttributeOverride(name = "homeNumber", column = @Column(name = "post_home_number")),
            @AttributeOverride(name = "apartmentn", column = @Column(name = "post_apartment_n")),
    })
    @Embedded
    private Address postAddress;

    @Column(name = "ptn_n")
    private String ptnN;

    @Column(name="phone_number")
    @Pattern(regexp = "\\+375[0-9]{9}")
    private String phoneNumber;

    @Column(name="telegram_number")
    @Pattern(regexp = "\\+375[0-9]{9}")
    private String telegramNumber;

    @Column(name="viber_number")
    @Pattern(regexp = "\\+375[0-9]{9}")
    private String viberNumber;

    @Column(name="whatsapp_number")
    @Pattern(regexp = "\\+375[0-9]{9}")
    private String whatsappNumber;
}
