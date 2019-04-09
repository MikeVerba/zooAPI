package com.example.zoo.bootstrap;

import com.example.zoo.domain.Bear;
import com.example.zoo.domain.Dog;
import com.example.zoo.domain.Tiger;
import com.example.zoo.domain.Wolf;
import com.example.zoo.repositories.BearRepository;
import com.example.zoo.repositories.DogRepository;
import com.example.zoo.repositories.TigerRepository;
import com.example.zoo.repositories.WolfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private BearRepository bearRepository;
    private TigerRepository tigerRepository;
    private WolfRepository wolfRepository;
    private DogRepository dogRepository;

    @Autowired
    public Bootstrap(BearRepository bearRepository, TigerRepository tigerRepository,
                     WolfRepository wolfRepository, DogRepository dogRepository) {
        this.bearRepository = bearRepository;
        this.tigerRepository = tigerRepository;
        this.wolfRepository = wolfRepository;
        this.dogRepository = dogRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadBearData();

        loadDogData();

        loadTigerData();

        loadWolfData();

    }

    private void loadBearData(){

        Bear yogi = new Bear();
        yogi.setName("Yogi");
        yogi.setWeight(200F);
        yogi.setFurLength(40);

        bearRepository.save(yogi);

        Bear bigBear = new Bear();
        bigBear.setName("Big Bear");
        bigBear.setWeight(400F);
        bigBear.setFurLength(60);

        bearRepository.save(bigBear);

        System.out.println("Bear data loaded: "+bearRepository.count());
    }

    private void loadTigerData(){

        Tiger jakata = new Tiger();
        jakata.setName("Jakata");
        jakata.setWeight(150F);
        jakata.setClawLength(25);

        tigerRepository.save(jakata);

        Tiger sherKhan = new Tiger();
        sherKhan.setName("Sher-Khan");
        sherKhan.setWeight(200F);
        sherKhan.setClawLength(40);

        tigerRepository.save(sherKhan);

        System.out.println("Tiger data loaded: "+tigerRepository.count());

    }

    private void loadWolfData(){

        Wolf howler = new Wolf();
        howler.setName("Howler");
        howler.setWeight(70F);
        howler.setFangLength(40);

        wolfRepository.save(howler);

        Wolf whiteWolf = new Wolf();
        whiteWolf.setName("White Wolf");
        whiteWolf.setWeight(90F);
        whiteWolf.setFangLength(50);

        wolfRepository.save(whiteWolf);

        System.out.println("Wolf data loaded: "+wolfRepository.count());


    }
    private void loadDogData(){

        Dog scooby = new Dog();
        scooby.setName("Scooby");
        scooby.setWeight(30F);

        dogRepository.save(scooby);

        Dog doobie = new Dog();
        doobie.setName("Doobie");
        doobie.setWeight(40F);

        dogRepository.save(doobie);

        Dog woobie = new Dog();
        woobie.setName("Woobie");
        woobie.setWeight(33F);

        dogRepository.save(woobie);

        Dog romper = new Dog();
        romper.setName("Romper");
        romper.setWeight(45F);

        dogRepository.save(romper);

        Dog phaphick = new Dog();
        phaphick.setName("Phaphick");
        phaphick.setWeight(22F);

        dogRepository.save(phaphick);

        System.out.println("Dog data loaded: "+dogRepository.count());

    }
}
