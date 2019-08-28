package br.com.runescape.Service;

import br.com.runescape.Entity.*;
import br.com.runescape.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OverallService implements IOverallService {

    @Autowired
    private OverallRepository overallRepository;
    @Autowired
    private AttackRepository attackService;
    @Autowired
    private DefenseRepository defenseService;
    @Autowired
    private MagicRepository magicService;
    @Autowired
    private CraftingRepository craftingService;
    @Autowired
    private CookingRepository cookingService;

    @Override
    public List<Overall> readAll() {
        List<Overall> overalls = new ArrayList<>();

        List<Attack> attacks = new ArrayList<>();
        attacks = (List<Attack>) attackService.findAll();
        List<Defense> defenses = new ArrayList<>();
        defenses = (List<Defense>) defenseService.findAll();
        List<Magic> magics = new ArrayList<>();
        magics = (List<Magic>) magicService.findAll();
        List<Cooking> cookings = new ArrayList<>();
        cookings = (List<Cooking>) cookingService.findAll();
        List<Crafting> craftings = new ArrayList<>();
        craftings = (List<Crafting>) craftingService.findAll();

        for(Attack attack : attacks) {
            if (overallRepository.existsByName(attack.getName()) == false) {
                String name = attack.getName();
                int level = attack.getLevel();
                long xp = attack.getXp();
                if (defenseService.existsByName(attack.getName())) {
                    level += defenseService.findByName(attack.getName()).getLevel();
                    xp += defenseService.findByName(attack.getName()).getXp();
                }
                if (magicService.existsByName(attack.getName())) {
                    level += magicService.findByName(attack.getName()).getLevel();
                    xp += magicService.findByName(attack.getName()).getXp();
                }
                if (cookingService.existsByName(attack.getName())) {
                    level += cookingService.findByName(attack.getName()).getLevel();
                    xp += cookingService.findByName(attack.getName()).getXp();
                }
                if (craftingService.existsByName(attack.getName())) {
                    level += craftingService.findByName(attack.getName()).getLevel();
                    xp += craftingService.findByName(attack.getName()).getXp();
                }

                overallRepository.save(new Overall(name, level, xp));
            }
        }

            for(Defense defense : defenses) {
                if (overallRepository.existsByName(defense.getName()) == false) {
                    String name = defense.getName();
                    int level = defense.getLevel();
                    long xp = defense.getXp();
                    if (magicService.existsByName(defense.getName())) {
                        level += magicService.findByName(defense.getName()).getLevel();
                        xp += magicService.findByName(defense.getName()).getXp();
                    }
                    if (cookingService.existsByName(defense.getName())) {
                        level += cookingService.findByName(defense.getName()).getLevel();
                        xp += cookingService.findByName(defense.getName()).getXp();
                    }
                    if (craftingService.existsByName(defense.getName())) {
                        level += craftingService.findByName(defense.getName()).getLevel();
                        xp += craftingService.findByName(defense.getName()).getXp();
                    }

                    overallRepository.save(new Overall(name, level, xp));
                }
            }

                for(Magic magic : magics){
                    if(overallRepository.existsByName(magic.getName()) == false){
                        String name = magic.getName();
                        int level = magic.getLevel();
                        long xp = magic.getXp();
                        if(cookingService.existsByName(magic.getName())){
                            level += cookingService.findByName(magic.getName()).getLevel();
                            xp += cookingService.findByName(magic.getName()).getXp();
                        }
                        if(craftingService.existsByName(magic.getName())){
                            level += craftingService.findByName(magic.getName()).getLevel();
                            xp += craftingService.findByName(magic.getName()).getXp();
                        }

                        overallRepository.save(new Overall(name,level,xp));
                    }
                }
                    for(Cooking cooking : cookings) {
                        if (overallRepository.existsByName(cooking.getName()) == false) {
                            String name = cooking.getName();
                            int level = cooking.getLevel();
                            long xp = cooking.getXp();

                            if (craftingService.existsByName(cooking.getName())) {
                                level += craftingService.findByName(cooking.getName()).getLevel();
                                xp += craftingService.findByName(cooking.getName()).getXp();
                            }

                            overallRepository.save(new Overall(name, level, xp));
                        }
                    }

                        for(Crafting crafting : craftings) {
                            if (overallRepository.existsByName(crafting.getName()) == false) {
                                String name = crafting.getName();
                                int level = crafting.getLevel();
                                long xp = crafting.getXp();
                                overallRepository.save(new Overall(name, level, xp));
                            }
                        }

                        overallRepository.findAll().forEach(overalls::add);
                        return overalls.stream()
                                .sorted(Comparator.comparingInt(Overall::getLevel).thenComparing(Overall::getXp).reversed())
                                .collect(Collectors.toList());

    }
}
