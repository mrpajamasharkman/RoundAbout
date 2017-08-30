package com.lucastiedeman.roundabout;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by Lucas on 8/18/2017.
 *
 * An actor doesn't need to display any information other than name, initiative,
 * and any sustained effects - all other stats are outside the scope of this tiny
 * project.
 */

public class Actor {
    private static Logger LOGGER = Logger.getLogger(Actor.class.getName());

    private String name;
    private int actorInit;
    private ArrayList<Effect> effects = new ArrayList<>();

    public Actor() { }

    public Actor(String name, int actorInit) {
        this.name = name;
        this.actorInit = actorInit;
    }

    public void change(int change, int currentInit) {
        for (int i = 0; i < effects.size(); i++) {
            effects.get(i).change(change);
            if (effects.get(i).getDuration() <= 0)
                effects.remove(i);
        }
        // Must find how to use currentInit to properly check whether an effect's duration should change
    }

    public String getName() { return name; }

    public int getActorInit() { return actorInit; }

    public String getEffects() {
        String printEffects = "";

        for (int i = 0; i < effects.size(); i++)
            printEffects += "\n\t" + effects.get(i).getDuration() + "\t" + effects.get(i).getDescription();

        return printEffects;
    }

    public void setName(String name) { this.name = name; }

    public void setActorInit(int actorInit) { this.actorInit = actorInit; }

    public void addEffect(String description, int duration) {
        Effect temp = new Effect(description, duration);
        effects.add(temp);
    }

    public String toString() {
        return  "Name:\t\t\n" + getName() +
                "\nInitiative:\t" + getActorInit() +
                getEffects();
    }
}
