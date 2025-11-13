package servlet;

import entity.Charakter;
import entity.Clasz;
import entity.Race;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/character")
public class CharacterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/page-character.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String playerName = req.getParameter("player_name");
//        String raceParam = req.getParameter("race");
//        String claszParam = req.getParameter("clasz");
//
//        int strength = Integer.parseInt(req.getParameter("strength"));
//        int dexterity = Integer.parseInt(req.getParameter("dexterity"));
//        int constitution = Integer.parseInt(req.getParameter("constitution"));
//        int intelligence = Integer.parseInt(req.getParameter("intelligence"));
//        int wisdom = Integer.parseInt(req.getParameter("wisdom"));
//        int charisma = Integer.parseInt(req.getParameter("charisma"));
//
//        int armorClass = Integer.parseInt(req.getParameter("armorClass"));
//        int initiative = Integer.parseInt(req.getParameter("initiative"));
//        int speed = Integer.parseInt(req.getParameter("speed"));
//        int hitPoints = Integer.parseInt(req.getParameter("hitPoints"));
//        int temporaryHitPoints = Integer.parseInt(req.getParameter("temporaryHitPoints"));
//        int hitDice = Integer.parseInt(req.getParameter("hitDice"));
//
//        int gold = Integer.parseInt(req.getParameter("gold"));
//        int silver = Integer.parseInt(req.getParameter("silver"));
//        int copper = Integer.parseInt(req.getParameter("copper"));
//        int level = Integer.parseInt(req.getParameter("level"));


        String name = req.getParameter("name");
        System.out.println("name = " + name);

        String playerName = req.getParameter("player_name");
        System.out.println("player_name = " + playerName);

        String raceParam = req.getParameter("race");
        System.out.println("raceParam = " + raceParam);

        String claszParam = req.getParameter("clasz");
        System.out.println("claszParam = " + claszParam);

        int strength = Integer.parseInt(req.getParameter("strength"));
        System.out.println("strength = " + strength);

        int dexterity = Integer.parseInt(req.getParameter("dexterity"));
        System.out.println("dexterity = " + dexterity);

        int constitution = Integer.parseInt(req.getParameter("constitution"));
        System.out.println("constitution = " + constitution);

        int intelligence = Integer.parseInt(req.getParameter("intelligence"));
        System.out.println("intelligence = " + intelligence);

        int wisdom = Integer.parseInt(req.getParameter("wisdom"));
        System.out.println("wisdom = " + wisdom);

        int charisma = Integer.parseInt(req.getParameter("charisma"));
        System.out.println("charisma = " + charisma);

        int armorClass = Integer.parseInt(req.getParameter("armorClass"));
        System.out.println("armorClass = " + armorClass);

        int initiative = Integer.parseInt(req.getParameter("initiative"));
        System.out.println("initiative = " + initiative);

        int speed = Integer.parseInt(req.getParameter("speed"));
        System.out.println("speed = " + speed);

        int hitPoints = Integer.parseInt(req.getParameter("hitPoints"));
        System.out.println("hitPoints = " + hitPoints);

        int temporaryHitPoints = Integer.parseInt(req.getParameter("temporaryHitPoints"));
        System.out.println("temporaryHitPoints = " + temporaryHitPoints);

        int hitDice = Integer.parseInt(req.getParameter("hitDice"));
        System.out.println("hitDice = " + hitDice);

        int gold = Integer.parseInt(req.getParameter("gold"));
        System.out.println("gold = " + gold);

        int silver = Integer.parseInt(req.getParameter("silver"));
        System.out.println("silver = " + silver);

        int copper = Integer.parseInt(req.getParameter("copper"));
        System.out.println("copper = " + copper);

        int level = Integer.parseInt(req.getParameter("level"));
        System.out.println("level = " + level);



        Race race = Race.valueOf(raceParam);
        Clasz clasz = Clasz.valueOf(claszParam);

        HttpSession session = req.getSession();

        Charakter charakter = Charakter.builder()
                .name(name)
                .playerName(playerName)
                .clasz(clasz)
                .race(race)
                .level(level)
                .strength(strength)
                .dexterity(dexterity)
                .constitution(constitution)
                .intelligence(intelligence)
                .wisdom(wisdom)
                .charisma(charisma)
                .armorClass(armorClass)
                .initiative(initiative)
                .speed(speed)
                .hitPoints(hitPoints)
                .temporaryHitPoints(temporaryHitPoints)
                .hitDice(hitDice)
                .gold(gold)
                .silver(silver)
                .copper(copper)
                .build();

        session.setAttribute("charakter", charakter);

        resp.sendRedirect(req.getContextPath() + "/character");
    }
}
