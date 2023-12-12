package com.adeo.postgreCrud.services;

import com.adeo.postgreCrud.models.Foucom;
import com.adeo.postgreCrud.models.Supplier;
import com.adeo.postgreCrud.models.Tiers;
import com.adeo.postgreCrud.repositories.FoucomRepository;
import com.adeo.postgreCrud.repositories.SupplierRepository;
import com.adeo.postgreCrud.repositories.TiersRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Component
public class DataSeeder {

	private final TiersRepository tiersRepository;
	private final FoucomRepository foucomRepository;
	private final SupplierRepository supplierRepository;

	@Autowired
	public DataSeeder(TiersRepository tiersRepository, FoucomRepository foucomRepository, SupplierRepository supplierRepository) {
		this.tiersRepository = tiersRepository;
		this.foucomRepository = foucomRepository;
		this.supplierRepository = supplierRepository;
	}

	public void seedData() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Faker faker = new Faker(new Locale("it"));
		enum Cod_famtie {MA, SE}

		for (int i = 0; i < 200; i++) {

			// Seeder for Tiers entity
			Tiers tiers = new Tiers();
			tiers.setNum_bu(faker.numerify("00#"));
			tiers.setNum_pay(tiers.getNum_bu());
			tiers.setNum_cen(Long.valueOf(tiers.getNum_bu()));
			tiers.setNum_tie(faker.number().randomNumber());
			tiers.setCod_typtie("FOU");
			tiers.setCod_famtie(faker.options().option(Cod_famtie.class).toString());
			tiers.setLib_tie(faker.lorem().characters(8, 32));
			tiers.setCod_dev(faker.currency().code());
			tiers.setTop_valid(faker.random().nextBoolean());
			tiers.setNum_modpai(2);
			tiers.setCod_condpai("F90");
			tiers.setCod_posfisc("X");
			tiers.setNum_payexp(1);
			tiers.setDat_cre("0");
			tiers.setDat_maj(simpleDateFormat.format(faker.date().birthday()));
			tiers.setTop_act(true);
			tiers.setDat_ref(2);
			tiers.setTop_xdock(faker.random().nextBoolean());

			// Seeder for Foucom entity
			Foucom foucom = new Foucom();
			foucom.setCod_statie("ACT");
			foucom.setCod_nattie("C");
			foucom.setCod_typgrp("JUR");
			foucom.setCod_siggrp(faker.expression("######").substring(faker.number().numberBetween(0, 5)));
			foucom.setNum_cp((int) faker.number().randomNumber());
			foucom.setNum_ass((int) faker.number().randomNumber());
			foucom.setNum_equip(faker.number().numberBetween(1, 16));
			foucom.setNbr_dec(faker.number().numberBetween(0, 4));
			foucom.setNum_trsfac(faker.number().numberBetween(0, 4));
			if (faker.random().nextBoolean()) {
				foucom.setTop_avs(true);
				foucom.setDat_avs(simpleDateFormat.format(faker.date().birthday()));
			} else {
				foucom.setTop_avs(false);
				foucom.setDat_avs("0");
			}
			foucom.setDat_debnego(simpleDateFormat.format(faker.date().birthday()));
			foucom.setDat_finnego(simpleDateFormat.format(faker.date().future(100, TimeUnit.DAYS)));
			foucom.setTx_remglofou((float) faker.number().numberBetween(0, 50));
			foucom.setTx_remlog((float) faker.number().numberBetween(0, 50));
			foucom.setTop_rfa(true);
			foucom.setTop_prospect(false);
			foucom.setTop_codean(true);
			foucom.setTop_superfou(true);
			foucom.setTop_superfouintl(true);
			foucom.setTop_fouachintl(true);
			foucom.setTop_founot(true);
			foucom.setCod_typtiefin("PAY");
			foucom.setNum_tiefin(faker.number().numberBetween(0, 999999));
			foucom.setCod_typtiecpt("FAC");
			foucom.setNum_tiecpt(faker.number().numberBetween(200000, 200999));
			foucom.setNum_pay_jur(faker.number().numberBetween(4, 700));
			foucom.setTop_cu(false);
			foucom.setTx_remise_cu((float) faker.number().numberBetween(0, 50));

			Supplier supplier = new Supplier();
			supplier.setTiers(tiersRepository.save(tiers));
			supplier.setFoucom(foucomRepository.save(foucom));
			supplierRepository.save(supplier);
		}

	}

}
