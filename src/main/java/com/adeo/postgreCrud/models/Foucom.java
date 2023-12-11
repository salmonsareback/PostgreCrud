package com.adeo.postgreCrud.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "foucom")
public class Foucom implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id")
	private Long id;
	@Column( columnDefinition = "CHAR(3)")
	private String cod_statie;
	@Column( columnDefinition = "CHAR(1)")
	private String cod_nattie;
	@Column( columnDefinition = "CHAR(3)")
	private String cod_typgrp;
	@Column( columnDefinition = "CHAR(3)")
	private String cod_siggrp;
//	private String cod_etaexp;
	private Integer num_cp;
	private Integer num_ass;
	private Integer num_equip;
	private Integer nbr_dec;
	private Integer num_trsfac;
	private Boolean top_avs;
	@Column( columnDefinition = "VARCHAR(10)")
	private String dat_avs;
	@Column( columnDefinition = "VARCHAR(10)")
	private String dat_debnego;
	@Column( columnDefinition = "VARCHAR(10)")
	private String dat_finnego;
	private Float tx_remglofou;
	private Float tx_remlog;
	private Boolean top_rfa;
	private Boolean top_prospect;
	private Boolean top_codean;
	private Boolean top_superfou;
	private Boolean top_superfouintl;
	private Boolean top_fouachintl;
	private Boolean top_founot;
	private Integer num_trstar;
	private String cod_typtiefin;
	private Integer num_tiefin;
	@Column( columnDefinition = "CHAR(3)")
	private String cod_typtiecpt;
	private Integer num_tiecpt;
//	private String cod_ent;
	private Integer num_pay_jur;
	private Boolean top_cu;
	private Float tx_remise_cu;

	@OneToOne(mappedBy = "Foucom", cascade = CascadeType.ALL)
	private Supplier supplier;
}
