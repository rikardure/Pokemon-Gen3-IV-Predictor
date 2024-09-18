package gen3check.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import gen3check.Controller;
import gen3check.pokemon.data.PokemonData;
import gen3check.pokemon.data.StatPack;
import gen3check.preset.PresetDTO;
import gen3check.preset.PresetRepo;
import gen3check.util.ComboBoxUtil;
import gen3check.util.DataListUtil;
import gen3check.pokemon.data.Data;


public class IVCheckPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8049597441234291025L;
	public IVCheckPanel(MainWindow mainWindow, Controller c, RestPanel rp) {
		this.mw = mainWindow;
		this.c = c;
		this.rp = rp;
		this.setParams();
	}
	
	private void setParams() {
		this.pkmIconLabel = new JLabel(new PokemonIcon(1));
		this.pkmIconLabel.setPreferredSize(new Dimension(64,64));
		this.pkmIconLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		this.pkmIconLabel.setOpaque(true);
		this.cmbPokemon = new JComboBox<PokemonData>();
		this.cmbPokemon.setModel(new DefaultComboBoxModel(DataListUtil.pokemonList));
		this.cmbPokemon.setEnabled(true);
		this.cmbPokemon.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				PokemonData pkm = (PokemonData) cmbPokemon.getSelectedItem();
				pkmIconLabel.setIcon(new PokemonIcon(pkm.getID()));
			}
		});
		this.cmbPokemon.setSelectedItem(ComboBoxUtil.getComboBoxItem(this.cmbPokemon, 1));
		
		this.txtHP = new IntegerJTextField(2);
		this.txtAtk = new IntegerJTextField[3];
		this.txtDef = new IntegerJTextField[3];
		this.txtSpa = new IntegerJTextField[3];
		this.txtSpd = new IntegerJTextField[3];
		this.txtSpe = new IntegerJTextField[3];
		for (int i = 0; i < 3; i++){
			this.txtAtk[i] = new IntegerJTextField(2);
			this.txtDef[i] = new IntegerJTextField(2);
			this.txtSpa[i] = new IntegerJTextField(2);
			this.txtSpd[i] = new IntegerJTextField(2);
			this.txtSpe[i] = new IntegerJTextField(2);
		}
		this.txtID = new IntegerJTextField(5);
		this.txtMinFrame = new IntegerJTextField(6);
		this.txtMaxFrame = new IntegerJTextField(6);
		this.setLayout(new BorderLayout());
		this.add(new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 3804266958635409584L;

			{
				this.setBorder(new TitledBorder("IV Constraint"));
				this.setLayout(new BorderLayout());
				this.add(new JPanel(){
					{
						this.setLayout(new GridLayout(7,2));
						this.add(Box.createGlue());
						this.add(new JPanel(){{
							this.setLayout(new GridLayout(1,3));
							this.add(new JLabel("-", SwingConstants.CENTER));
							this.add(new JLabel("Neutral", SwingConstants.CENTER));
							this.add(new JLabel("+", SwingConstants.CENTER));
						}});
						this.add(new JLabel("HP"));
						this.add(txtHP);
						this.add(new JLabel("Attack"));
						this.add(new JPanel(){{
							this.setLayout(new GridLayout(1,3));
							for (int i = 0; i < 3; i++) this.add(txtAtk[i]);
						}});
						this.add(new JLabel("Defense"));
						this.add(new JPanel(){{
							this.setLayout(new GridLayout(1,3));
							for (int i = 0; i < 3; i++) this.add(txtDef[i]);
						}});
						this.add(new JLabel("Sp. Atk"));
						this.add(new JPanel(){{
							this.setLayout(new GridLayout(1,3));
							for (int i = 0; i < 3; i++) this.add(txtSpa[i]);
						}});
						this.add(new JLabel("Sp. Def"));
						this.add(new JPanel(){{
							this.setLayout(new GridLayout(1,3));
							for (int i = 0; i < 3; i++) this.add(txtSpd[i]);
						}});
						this.add(new JLabel("Speed"));
						this.add(new JPanel(){{
							this.setLayout(new GridLayout(1,3));
							for (int i = 0; i < 3; i++) this.add(txtSpe[i]);
						}});
					}
				}, BorderLayout.CENTER);
				this.add(new JButton("Clear"){
					{
						this.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent arg0) {
								txtHP.setText("0");
								for (int i = 0; i < 3; i++){
									txtAtk[i].setText("0");
									txtDef[i].setText("0");
									txtSpa[i].setText("0");
									txtSpd[i].setText("0");
									txtSpe[i].setText("0");
								}
							}
						});
					}
				}, BorderLayout.SOUTH);

			}
		}, BorderLayout.NORTH);


		this.add(new JPanel(){
			private static final long serialVersionUID = 7133290352265769708L;
			{
				this.setLayout(new BorderLayout());
				this.setBorder(new TitledBorder("Starter Pokemon"));
				this.add(new JPanel(){
					{
						this.setLayout(new GridLayout(1,0));
						this.add(Box.createGlue());
						this.add(pkmIconLabel);
						this.add(Box.createGlue());
					}
				}, BorderLayout.NORTH);
				this.add(new JPanel(){
					{
						this.setLayout(new GridLayout(6,2));
						this.add(new JLabel("Pokemon"));
						this.add(cmbPokemon);
						this.add(new JLabel("Min Frame"));
						this.add(txtMinFrame);
						this.add(new JLabel("Max Frame"));
						this.add(txtMaxFrame);
						this.add(Box.createGlue());
						this.add(Box.createGlue());
						this.add(new JLabel("Trainer ID"));
						this.add(txtID);
						this.add(Box.createGlue());
						this.add(new JButton("Clear TID"){
							{
								this.addActionListener(new ActionListener(){
									@Override
									public void actionPerformed(ActionEvent arg0) {
										txtID.setText("");
									}
								});
							}
						});
					}
				}, BorderLayout.CENTER);
				this.add(new JPanel() {
				
					{
				this.add(new JButton("Search"){
					{
						this.setPreferredSize(new Dimension(70,40));
						this.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent arg0) {
								if (txtHP.isEmpty()) txtHP.setText("0");
								for (int i = 0; i < 3; i++){
									if (txtAtk[i].isEmpty()) txtAtk[i].setText("0");
									if (txtDef[i].isEmpty()) txtDef[i].setText("0");
									if (txtSpa[i].isEmpty()) txtSpa[i].setText("0");
									if (txtSpd[i].isEmpty()) txtSpd[i].setText("0");
									if (txtSpe[i].isEmpty()) txtSpe[i].setText("0");
								}
								if (txtID.isEmpty()) txtID.setText("0");
								if (Integer.parseInt(txtID.getText()) > 65535) txtID.setText("0");
								if (Integer.parseInt(txtHP.getText()) > 31) txtHP.setText("31");
								for (int i = 0; i < 3; i++){
									if (Integer.parseInt(txtAtk[i].getText()) > 31) txtAtk[i].setText("31");
									if (Integer.parseInt(txtDef[i].getText()) > 31) txtDef[i].setText("31");
									if (Integer.parseInt(txtSpa[i].getText()) > 31) txtSpa[i].setText("31");
									if (Integer.parseInt(txtSpd[i].getText()) > 31) txtSpd[i].setText("31");
									if (Integer.parseInt(txtSpe[i].getText()) > 31) txtSpe[i].setText("31");
								}
								if (txtMinFrame.isEmpty()) txtMinFrame.setText("0");
								if (txtMaxFrame.isEmpty()) txtMaxFrame.setText("0");
								if (Integer.parseInt(txtMaxFrame.getText()) < Integer.parseInt(txtMinFrame.getText())){
									txtMaxFrame.setText(txtMinFrame.getText());
								}
								c.search(
										Integer.parseInt(txtMinFrame.getText()),
										Integer.parseInt(txtMaxFrame.getText()),
										Integer.parseInt(txtID.getText()),
										((PokemonData) cmbPokemon.getSelectedItem()).getID(),
										new StatPack(
											Integer.parseInt(txtHP.getText()),
											Integer.parseInt(txtAtk[0].getText()),
											Integer.parseInt(txtDef[0].getText()),
											Integer.parseInt(txtSpa[0].getText()),
											Integer.parseInt(txtSpd[0].getText()),
											Integer.parseInt(txtSpe[0].getText())	
										),
										new StatPack(
											Integer.parseInt(txtHP.getText()),
											Integer.parseInt(txtAtk[1].getText()),
											Integer.parseInt(txtDef[1].getText()),
											Integer.parseInt(txtSpa[1].getText()),
											Integer.parseInt(txtSpd[1].getText()),
											Integer.parseInt(txtSpe[1].getText())	
										),
										new StatPack(
											Integer.parseInt(txtHP.getText()),
											Integer.parseInt(txtAtk[2].getText()),
											Integer.parseInt(txtDef[2].getText()),
											Integer.parseInt(txtSpa[2].getText()),
											Integer.parseInt(txtSpd[2].getText()),
											Integer.parseInt(txtSpe[2].getText())	
										),
										rp.getNatures()
										);
							}
						});
					}
				}, BorderLayout.NORTH);
				
				this.add(new JButton("Save") {
					{
						this.setPreferredSize(new Dimension(70, 30));
						this.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								if (txtHP.isEmpty()) txtHP.setText("0");
								for (int i = 0; i < 3; i++){
									if (txtAtk[i].isEmpty()) txtAtk[i].setText("0");
									if (txtDef[i].isEmpty()) txtDef[i].setText("0");
									if (txtSpa[i].isEmpty()) txtSpa[i].setText("0");
									if (txtSpd[i].isEmpty()) txtSpd[i].setText("0");
									if (txtSpe[i].isEmpty()) txtSpe[i].setText("0");
								}
								if (txtID.isEmpty()) txtID.setText("0");
								if (Integer.parseInt(txtID.getText()) > 65535) txtID.setText("0");
								if (Integer.parseInt(txtHP.getText()) > 31) txtHP.setText("31");
								for (int i = 0; i < 3; i++){
									if (Integer.parseInt(txtAtk[i].getText()) > 31) txtAtk[i].setText("31");
									if (Integer.parseInt(txtDef[i].getText()) > 31) txtDef[i].setText("31");
									if (Integer.parseInt(txtSpa[i].getText()) > 31) txtSpa[i].setText("31");
									if (Integer.parseInt(txtSpd[i].getText()) > 31) txtSpd[i].setText("31");
									if (Integer.parseInt(txtSpe[i].getText()) > 31) txtSpe[i].setText("31");
								}
								if (txtMinFrame.isEmpty()) txtMinFrame.setText("0");
								if (txtMaxFrame.isEmpty()) txtMaxFrame.setText("0");
								if (Integer.parseInt(txtMaxFrame.getText()) < Integer.parseInt(txtMinFrame.getText())){
									txtMaxFrame.setText(txtMinFrame.getText());
								}
								
								List<Boolean> natures = new ArrayList<>();
								JCheckBox[] boxes = rp.getNatures();
								for (int i = 0; i< rp.getNatures().length; i++)
								{
									natures.add(boxes[i].isSelected());
								}
								Data selectedPokemon = (Data)cmbPokemon.getSelectedItem();

								PresetDTO preset = new PresetDTO(selectedPokemon.getID(),
										Integer.parseInt(txtHP.getText()),
										Integer.parseInt(txtAtk[0].getText()),
										Integer.parseInt(txtAtk[1].getText()),
										Integer.parseInt(txtAtk[2].getText()),
										Integer.parseInt(txtDef[0].getText()),
										Integer.parseInt(txtDef[1].getText()),
										Integer.parseInt(txtDef[2].getText()),
										Integer.parseInt(txtSpa[0].getText()),
										Integer.parseInt(txtSpa[1].getText()),
										Integer.parseInt(txtSpa[2].getText()),
										Integer.parseInt(txtSpd[0].getText()),
										Integer.parseInt(txtSpd[1].getText()),
										Integer.parseInt(txtSpd[2].getText()),
										Integer.parseInt(txtSpe[0].getText()),
										Integer.parseInt(txtSpe[1].getText()),
										Integer.parseInt(txtSpe[2].getText()),
										Integer.parseInt(txtMinFrame.getText()),
										Integer.parseInt(txtMaxFrame.getText()),
										natures);
								PresetRepo repository =	new PresetRepo();
								repository.save(preset);
							}
						});
					}
				}, BorderLayout.WEST);
				
				this.add(new JButton("Load") {
					{
						this.setPreferredSize(new Dimension(70, 30));
						this.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {

							
								PresetRepo repository =	new PresetRepo();
								PresetDTO preset = repository.load();
								
								cmbPokemon.setSelectedItem(ComboBoxUtil.getComboBoxItem(cmbPokemon, preset.getPokemonId()));
								txtAtk[0].setText(preset.getAttack_minus().toString());
								txtAtk[1].setText(preset.getAttack_neutral().toString());
								txtAtk[2].setText(preset.getAttack_plus().toString());
								txtDef[0].setText(preset.getDefense_minus().toString());
								txtDef[1].setText(preset.getDefense_neutral().toString());
								txtDef[2].setText(preset.getDefense_plus().toString());
								txtSpa[0].setText(preset.getSpAtk_minus().toString());
								txtSpa[1].setText(preset.getSpAtk_neutral().toString());
								txtSpa[2].setText(preset.getSpAtk_plus().toString());
								txtSpd[0].setText(preset.getSpDef_minus().toString());
								txtSpd[1].setText(preset.getSpDef_neutral().toString());
								txtSpd[2].setText(preset.getSpDef_plus().toString());
								txtSpe[0].setText(preset.getSpeed_minus().toString());
								txtSpe[1].setText(preset.getSpeed_neutral().toString());
								txtSpe[2].setText(preset.getSpeed_plus().toString());
								txtHP.setText(preset.getHP().toString());
								txtMinFrame.setText(preset.getMin_frame().toString());
								txtMaxFrame.setText(preset.getMax_frame().toString());
								
								JCheckBox[] boxes = rp.getNatures();
								List<Boolean> natures = preset.getNatures();
								for(int i = 0; i < rp.getNatures().length; i++)
								{
									boxes[i].setSelected(natures.get(i));
								}
								
							}
						});
					}
				}, BorderLayout.EAST);
				
				
					}
				}, BorderLayout.SOUTH);
			}
		}, BorderLayout.CENTER);
		
		
	}

	private MainWindow mw;
	private Controller c;
	private RestPanel rp;
	private JLabel pkmIconLabel;
	private IntegerJTextField txtLevel;
	private IntegerJTextField txtHP;
	private IntegerJTextField txtAtk[];
	private IntegerJTextField txtDef[];
	private IntegerJTextField txtSpa[];
	private IntegerJTextField txtSpd[];
	private IntegerJTextField txtSpe[];
	private IntegerJTextField txtID;
	private IntegerJTextField txtMaxFrame;
	private IntegerJTextField txtMinFrame;
	private JComboBox<PokemonData> cmbPokemon;
}
