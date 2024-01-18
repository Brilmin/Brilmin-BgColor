package com.example.codestates.band.entity;


import com.example.codestates.audit.Auditable;
import com.example.codestates.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class BandJoinList extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bandJoinListId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NICKNAME")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "BAND_ID")
    private Band band;


}
