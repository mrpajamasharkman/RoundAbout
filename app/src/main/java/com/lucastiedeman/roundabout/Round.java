package com.lucastiedeman.roundabout;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by Lucas on 8/18/2017.
 */

public class Round {
    private static Logger LOGGER = Logger.getLogger(Round.class.getName());

    private int round;
    private ArrayList<Actor> actors = new ArrayList<>();
    private Actor actor;
    private int nextActorIndex;

    public Round() {
        setRound(0);

        setActor(null);
        setNextActorIndex(0);
    }

    //  Called by nextActor button
    public void nextActor() {
        if (actors.isEmpty())
            actor = null;

        if (nextActorIndex >= actors.size() || nextActorIndex < 0)
            nextActorIndex = 0;

        setActor(actors.get(getNextActorIndex()));
        setNextActorIndex(nextActorIndex + 1);
    }

    //  Also called by roundLabel
    public int getRound() { return round; }

    //  Called by actualTime
    public String getTime() {
        int seconds = getRound() * 6;
        int minutes = seconds / 60;
        int hours = seconds / 3600;
        seconds %= 60;

        return hours + ":" + minutes + ":" + seconds;
    }

    //  Called by actorList
    public void getActorList() { }

    public int getNextActorIndex() { return nextActorIndex; }

    public void setRound (int round) {
        int change = round - this.round;

        for (int i = 0; i < actors.size(); i++)
            actors.get(i).change(change);

        this.round = round;
    }

    public void setActor(Actor actor) { this.actor = actor; }

    public void setNextActorIndex(int nextActorIndex) { this.nextActorIndex = nextActorIndex; }
}
