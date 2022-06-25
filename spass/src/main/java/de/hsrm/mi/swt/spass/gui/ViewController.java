package de.hsrm.mi.swt.spass.gui;

import de.hsrm.mi.swt.spass.Main;
import javafx.scene.layout.Pane;
/**
 * Abstrakte Klasse fuer ViewController
 * @author Kevin Emunds, Astrid Klemmer, Victoria Thee
 *
 */
public abstract class ViewController {
	
	protected Pane rootView;
	protected Main main;
/**
 * Konstruktor zum Erstellen eines ViewControllers
 */
	public ViewController() {
		
	}

	public abstract void initialize();

	public Pane getRootView() {
		return rootView;
	}
	
}
