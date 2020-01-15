package com.example.ppkwulab4.service;

import com.example.ppkwulab4.model.Person;
import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.VCardVersion;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    public List<Person> getPeopleByName(String name) throws IOException {
        String searchUrl ="https://adm.edu.p.lodz.pl/user/users.php?search=" + name;
        List<Person> people = new ArrayList<>();

        Document document = Jsoup.connect(searchUrl).get();

        Elements elements = document.select("div.user-info");

        for( int i = 0; i < elements.size(); i++) {

            String nameCard = "";
            String titleCard = "";
            String placeCard = "";

            if (!elements.get(i).select("h3").text().equals("")) {
               nameCard = elements.get(i).select("h3").text();
            }
            if (!elements.get(i).select("h4").text().equals("")) {
                titleCard = elements.get(i).select("h4").text();
            }
            if (!elements.get(i).select("span.item-content").text().equals("")) {
                placeCard = elements.get(i).select("span.item-content").text();
            }

            Person person = new Person(nameCard, titleCard, placeCard);
            people.add(person);
        }

        return people;
    }

    public ResponseEntity<Resource> generateVCard(String name, int index) throws IOException {
        VCard vcard = new VCard();
        List<Person> people = getPeopleByName(name);

        Person person = people.get(index);

        vcard.setFormattedName(person.getName());

        if (person.getTitle() != null) {
            vcard.addTitle(person.getTitle());
        }

        if (person.getPlace() != null) {
            vcard.setOrganization(person.getPlace());
        }

        File file = new File("vcard.vcf");
        Ezvcard.write(vcard).version(VCardVersion.V3_0).go(file);

        InputStreamResource resource = new InputStreamResource(new FileInputStream("vcard.vcf"));
        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=vcard.vcf")
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("text/vcf")).body(resource);
    }
}
