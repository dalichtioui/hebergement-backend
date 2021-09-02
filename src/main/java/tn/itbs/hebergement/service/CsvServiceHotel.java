package tn.itbs.hebergement.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.itbs.hebergement.entities.Hotel;

@Service
@Slf4j
public class CsvServiceHotel {
	private static final String[] HEADERS = { "Id","Nom","Email","Adresse","Code Postal","Pays","Horaire",
			"Nombre de Chambre","Capacité global","Nombre Etages","Numero Siret","Immatriculation","Logo","Etat"};
	
	private static final CSVFormat FORMAT = CSVFormat.DEFAULT.withHeader(HEADERS);
	
	//load data to csv
	public ByteArrayInputStream load(final List<Hotel> hotels) {
		return writeDataToCsv(hotels);
	}
	//write data to csv
	private ByteArrayInputStream writeDataToCsv(final List<Hotel> hotels) {
		log.info("Writing data to the csv printer");
		try (final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		     final CSVPrinter printer = new CSVPrinter(new PrintWriter(stream), FORMAT)){
			for (final Hotel hotel : hotels) {
				final List<String> data = Arrays.asList(
						String.valueOf(hotel.getHotelId()),
						hotel.getEmail(),
						hotel.getAdresse(),
						String.valueOf(hotel.getCodePostal()),
						hotel.getPays(),
						hotel.getHoraire(),
						String.valueOf(hotel.getNombreDeChambre()),
						String.valueOf(hotel.getCapaciteGlobal()),
						String.valueOf(hotel.getNombreEtages()),
						String.valueOf(hotel.getNumeroSiret()),
						String.valueOf(hotel.getImmatriculation()),
						String.valueOf(hotel.getLogo()),
						String.valueOf(hotel.isEtat()));
						
						printer.printRecord(data);
			}
			printer.flush();
			return new ByteArrayInputStream(stream.toByteArray());
		
		} catch (final IOException e) {
            throw new RuntimeException("Csv writing error: " + e.getMessage());
	}
	}
}

