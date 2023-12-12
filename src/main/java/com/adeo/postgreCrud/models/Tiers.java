package com.adeo.postgreCrud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tiers")
public class Tiers implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id")
	private Long id;
	@Column(columnDefinition = "CHAR(3)")
	private String num_bu;
	@Column(columnDefinition = "CHAR(3)")
	private String num_pay;
	private Long num_cen;
	private Long num_tie;
	@Column(columnDefinition = "CHAR(3)")
	private String cod_typtie;
	@Column(columnDefinition = "CHAR(2)")
	private String cod_famtie;
	//	private String lic_tie;
	@Column(columnDefinition = "VARCHAR(32)")
	private String lib_tie;
//	@Column(columnDefinition = "CHAR(3)")
//	private String cod_lan;
	@Column(columnDefinition = "CHAR(3)")
	private String cod_dev;
	private Boolean top_valid;
	private Integer num_modpai;
	@Column(columnDefinition = "CHAR(3)")
	private String cod_condpai;
	@Column(columnDefinition = "CHAR(1)")
	private String cod_posfisc;
	private Integer num_payexp;
	@Column(columnDefinition = "VARCHAR(10)")
	private String dat_cre;
	@Column(columnDefinition = "VARCHAR(10)")
	private String dat_maj;
//	@Column(columnDefinition = "VARCHAR(10)")
//	private String dat_app;
//	@Column(columnDefinition = "VARCHAR(10)")
//	private String dat_fin;
	private Boolean top_act;
	//	private String cod_cptfou;
	//	private String cod_clarglt;
	private Integer dat_ref;
	private Boolean top_xdock;

	// This create infinite loop when stringtifying
//	@OneToOne(mappedBy = "Tiers", cascade = CascadeType.ALL)
//	private Supplier supplier;
}
