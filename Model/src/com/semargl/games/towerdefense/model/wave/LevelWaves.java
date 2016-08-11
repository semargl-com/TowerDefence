package com.semargl.games.towerdefense.model.wave;

import com.semargl.games.towerdefense.model.wave.WaveClass;

import java.util.List;

public class LevelWaves {
    public List<WaveClass> waveClasses;

    public LevelWaves(List<WaveClass> waveClasses) {
        this.waveClasses = waveClasses;
    }
}
