package br.com.codechallenge.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;
import br.com.codechallenge.model.Coupon;

@Service
public class CouponService {

	public Coupon addNewCoupon(String cpf) throws IOException {

		String lastCodeOut = validateCPF(cpf);
		if (lastCodeOut == null)
			return null;

		Coupon coupon = useCouponToCPF(cpf, lastCodeOut);

		String value = "\n" + coupon.getCode() + ";" + coupon.getCpf();
		addLineToOutCSV(value);

		return coupon;

	}

	@SuppressWarnings("resource")
	private String validateCPF(String cpf) throws IOException {

		URL resouceOut = getClass().getClassLoader().getResource("coupon_out.csv");
		BufferedReader out = new BufferedReader(new InputStreamReader(resouceOut.openStream()));
		CSVReader reader = new CSVReader(out);

		String[] lastCode = null;
		List<String[]> list = reader.readAll();

		if (list.isEmpty())
			return "novo";

		for (String[] line : list) {

			if (line[0].contains(cpf)) {
				return null;
			} else {
				lastCode = line;
			}

		}

		lastCode = lastCode[0].split(";");

		return lastCode[0];

	}

	@SuppressWarnings({ "resource" })
	private Coupon useCouponToCPF(String cpf, String lastCodeOut) throws IOException {

		URL resouceIn = getClass().getClassLoader().getResource("coupon_in.csv");
		BufferedReader in = new BufferedReader(new InputStreamReader(resouceIn.openStream()));
		CSVReader reader = new CSVReader(in);

		String nextCode = null;
		List<String[]> list = reader.readAll();
		boolean next = false;

		for (String[] line : list) {
			
			if (lastCodeOut.equals("novo")) {
				nextCode = line[0];
				break;
			}
			
			if (next) {
				nextCode = line[0];
				break;
			}

			if (line[0].equals(lastCodeOut)) {
				next = true;
			}
		}

		Coupon coupon = new Coupon();
		coupon.setCode(nextCode);
		coupon.setCpf(cpf);
		next = false;

		return coupon;
	}

	private void addLineToOutCSV(String value) throws IOException {
		URL resourceOut = getClass().getClassLoader().getResource("coupon_out.csv");
		File file = new File(resourceOut.getFile());
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.append(value);
		writer.flush();
		writer.close();
	}

}
