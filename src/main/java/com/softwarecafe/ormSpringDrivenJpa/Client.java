package com.softwarecafe.ormSpringDrivenJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Client {
    @Autowired
    HumenService humenService;
    public void run()
    {
        System.out.println("Persing Humens");
        Humen humen = Humen.create("Anshuman" , "dixit", "mahmoot ganj");
        humenService.saveHumen(humen);
        humen = Humen.create("Abhijit" , "dey", "sigra");
        humenService.saveHumen(humen);
        humen = Humen.create("ankit" , "dubey", "Lamahi");
        humenService.saveHumen(humen);

        System.out.println("______________ Loading Humens _____________________");
        List<Humen> humens = humenService.getAllHumens();
        humens.stream().forEach(humn-> System.out.println(humn));

        humen=humenService.getHumenById(2);
        System.out.println("Humen loaded by 2"+humen);

        System.out.println("Updating Humen Records of id 2");
        humen=humenService.getHumenById(2);
        humen.setAddress("near sigra petrol pump");
        humenService.updateHumen(humen);

        System.out.println("Deleting Humen by id 1");
        humenService.deleteHumen(2);

        System.out.println("Loading all Humens");
        humens=humenService.getAllHumens();
        System.out.println("Humens loaded"+humens);
    }
    public void clearTable(){
        humenService.clearTable();
    }
}
