package com.HumoPic;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.List;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
    	frequencyAnalyzer.setWordFrequenciesToReturn(500);
    	frequencyAnalyzer.setMinWordLength(0); 
    	final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("lyrics02.txt");
    	final Dimension dimension = new Dimension(700, 600);
    	final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
    	wordCloud.setPadding(0);
    	wordCloud.setBackground(new PixelBoundryBackground("twitter-1.png"));
    	// colors followed by and steps between
    	wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
    	wordCloud.setFontScalar( new SqrtFontScalar(10, 70));
    	wordCloud.build(wordFrequencies);
    	wordCloud.writeToFile("gradient_redbluegreen.png");
    }
}
