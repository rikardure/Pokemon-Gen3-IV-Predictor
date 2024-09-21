package gen3check.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import rng.PokemonRNG;


import gen3check.Controller;
import gen3check.PokemonFoundData;
import gen3check.pokemon.data.Ability;
import gen3check.pokemon.data.Nature;
import gen3check.pokemon.data.PokemonItem;
import gen3check.pokemon.data.StatPack;
import gen3check.preset.ScoreWeights;
import gen3check.pokemon.Pokemon;

public class RestPanel extends JPanel{
	public RestPanel(MainWindow mainWindow, Controller c) {
		this.mw = mainWindow;
		this.c = c;
		this.weights = new ScoreWeights(1);
		setTimeWeight(new JLabel("Time: " + weights.getTime_weight(), SwingConstants.CENTER));
		getTimeWeight().setForeground(Color.RED);
		setHPweight(new JLabel("HP: " + weights.getHP_weight(), SwingConstants.CENTER));
		setAtkweight(new JLabel("Atk: " + weights.getAttack_weight(), SwingConstants.CENTER));
		setDefweight(new JLabel("Def: " + weights.getDefense_weight(), SwingConstants.CENTER));
		setSpaweight(new JLabel("SpA: " + weights.getSpAtk_weight(), SwingConstants.CENTER));
		getSpaweight().setForeground(Color.gray);
		setSpdweight(new JLabel("SpD: " + weights.getSpDef_weight(), SwingConstants.CENTER));
		setSpeweight(new JLabel("Spe: " + weights.getSpeed_weight(), SwingConstants.CENTER));
		
		this.setParams();
	}
	
	public JCheckBox[] getNatures(){
		return chkNature;
	}
	
	public void updateSelectedPokemon(Pokemon pokemon, int frame){
		this.selectedPokemon = pokemon;
		this.selectedFrame = frame;
		this.revalidate();
		this.repaint();
	}
	
	private void setParams(){
		this.selectedPokemon = new Pokemon();
		this.chkNature = new JCheckBox[Nature.NATURE_N];
		this.pkmFoundPanel = new PokemonFoundPanel(mw,c,this);
		this.runType = new JComboBox<String>(new String[] { "Elite 4 Round 2 Score", "Any%  Score" }) {
            {
                this.setPreferredSize(new Dimension(200, 30)); // Optional: Customize size
                this.addActionListener(new ActionListener()
                		{
		                	@Override
		        			public void actionPerformed(ActionEvent e) {
		        				
		        				// TODO Auto-generated method stub
		        				if("Elite 4 Round 2 Score".equals(runType.getSelectedItem().toString()))
		        				{
		        					weights = new ScoreWeights(1);
		        				}
		        				else
		        				{
		        					weights = new ScoreWeights(2);
		        				}
		        				getTimeWeight().setText("Time: " + weights.getTime_weight());
		        				getTimeWeight().setForeground(Color.RED);
		        				getHPweight().setText("HP: " + weights.getHP_weight());
		        				getAtkweight().setText("Atk: " + weights.getAttack_weight());
		        				getDefweight().setText("Def: " + weights.getDefense_weight());
		        				getSpaweight().setText("SpA: " + weights.getSpAtk_weight());
		        				getSpdweight().setText("SpD: " + weights.getSpDef_weight());
		        				getSpeweight().setText("Spe: " + weights.getSpeed_weight());
		        			}
                	
                		});
            }
        };
		this.BOXPANEL = new ImageIcon(RestPanel.class.getResource("/image/thebox2.png")).getImage();
		this.setLayout(new BorderLayout());
		this.add(new JPanel(){
			{
				this.setBorder(new TitledBorder("Natures"));
				this.setLayout(new BorderLayout());
				this.add(new JPanel(){
					{
						this.setLayout(new GridLayout(5,5));
						for (int i = 0; i < Nature.NATURE_N; i++){
							chkNature[i] = new JCheckBox(new Nature(i).getName());
							this.add(chkNature[i]);
						}
					}
				}, BorderLayout.CENTER);
				this.add(new JPanel(){
					{
						this.setLayout(new GridLayout(1,2));
						this.add(new JButton("Check All"){
							{
								this.addActionListener(new ActionListener(){
									@Override
									public void actionPerformed(ActionEvent arg0) {
										for (int i = 0; i < Nature.NATURE_N; i++){
											chkNature[i].setSelected(true);
										}
									}
								});
							}
						});
						this.add(new JButton("Uncheck All"){
							{
								this.addActionListener(new ActionListener(){
									@Override
									public void actionPerformed(ActionEvent arg0) {
										for (int i = 0; i < Nature.NATURE_N; i++){
											chkNature[i].setSelected(false);
										}
									}
								});
							}
						});
					}
				}, BorderLayout.SOUTH);
				
					
			}
		}, BorderLayout.NORTH);
		
		
		
		this.add(pkmFoundPanel, BorderLayout.CENTER);
		
		this.add(new JPanel() {
		    {
		        this.setLayout(new BorderLayout());

		        // Upper panel with multiple components
		        this.add(new JPanel() {
		            {
		                this.setLayout(new GridLayout(1, 3));

		                // First inner panel
		                this.add(new JPanel() {
		                    {
		                        this.setPreferredSize(new Dimension(205, 75));
		                    }

		                    @Override
		                    public void paint(Graphics g) {
		                        g.drawImage(BOXPANEL, 0, 0, 200, 72, this);
		                        g.setColor(Color.WHITE);
		                        g.setFont(new Font("default", Font.BOLD, 12));
		                        g.drawString(Integer.toString(selectedPokemon.IV.hp), 19 - Integer.toString(selectedPokemon.IV.hp).length() * 4, 38);
		                        g.drawString(Integer.toString(selectedPokemon.IV.atk), 51 - Integer.toString(selectedPokemon.IV.atk).length() * 4, 38);
		                        g.drawString(Integer.toString(selectedPokemon.IV.def), 83 - Integer.toString(selectedPokemon.IV.def).length() * 4, 38);
		                        g.drawString(Integer.toString(selectedPokemon.IV.spa), 115 - Integer.toString(selectedPokemon.IV.spa).length() * 4, 38);
		                        g.drawString(Integer.toString(selectedPokemon.IV.spd), 147 - Integer.toString(selectedPokemon.IV.spd).length() * 4, 38);
		                        g.drawString(Integer.toString(selectedPokemon.IV.spe), 179 - Integer.toString(selectedPokemon.IV.spe).length() * 4, 38);
		                        g.drawString(" " + selectedPokemon.getNature().toString(), 85, 64);
		                    }
		                });

		                // Second inner panel
		                this.add(new JPanel() {
		                    {
		                        this.setPreferredSize(new Dimension(205, 75));
		                    }

		                    @Override
		                    public void paint(Graphics g) {
		                        g.drawImage(BOXPANEL, 0, 0, 200, 72, this);
		                        g.setColor(Color.WHITE);
		                        g.setFont(new Font("default", Font.BOLD, 12));
		                        g.drawString(Integer.toString(selectedPokemon.stat.hp), 19 - Integer.toString(selectedPokemon.stat.hp).length() * 4, 38);
		                        g.drawString(Integer.toString(selectedPokemon.stat.atk), 51 - Integer.toString(selectedPokemon.stat.atk).length() * 4, 38);
		                        g.drawString(Integer.toString(selectedPokemon.stat.def), 83 - Integer.toString(selectedPokemon.stat.def).length() * 4, 38);
		                        g.drawString(Integer.toString(selectedPokemon.stat.spa), 115 - Integer.toString(selectedPokemon.stat.spa).length() * 4, 38);
		                        g.drawString(Integer.toString(selectedPokemon.stat.spd), 147 - Integer.toString(selectedPokemon.stat.spd).length() * 4, 38);
		                        g.drawString(Integer.toString(selectedPokemon.stat.spe), 179 - Integer.toString(selectedPokemon.stat.spe).length() * 4, 38);
		                        g.drawString(" " + selectedPokemon.getNature().toString(), 85, 64);
		                    }
		                });
		            }
		        }, BorderLayout.NORTH);

		        // Button in the center
		        this.add(new JButton("Search Around Frame") {
		            {
		                this.setPreferredSize(new Dimension(100, 30));
		                this.addActionListener(new ActionListener() {
		                    @Override
		                    public void actionPerformed(ActionEvent arg0) {
		                        pkmFoundPanel.updateGridAround(selectedFrame);
		                    }
		                });
		            }
		        }, BorderLayout.CENTER);

		        // ComboBox in the SOUTH position
		        this.add(new JPanel() {
		        	{
		        		this.setSize(new Dimension(1550,50));
		        		this.add(runType, BorderLayout.NORTH);
		        		
		        		this.add(new JPanel() {
		                    {
		                        this.setLayout(new GridLayout(3, 6, 0, 5)); // 2 rows, 4 columns, with gaps

		                        // First row: "+" buttons and stat labels
		                        this.add(new JButton("+") {
		                            {
		                                this.addActionListener(e -> {
		                                	weights.setTime_weight(weights.getTime_weight()+1);
		                                	getTimeWeight().setText("Time: " + weights.getTime_weight());
		                                }
		                                );
		                            }
		                        });  // HP Plus Button
		                        this.add(new JButton("+") {
		                        	{
		                                this.addActionListener(e -> {
		                                	weights.setHP_weight(weights.getHP_weight()+1);
		                                	getHPweight().setText("HP: " + weights.getHP_weight());
		                                }
		                                );
		                            }
		                        });  // HP Plus Button
		                        this.add(new JButton("+") {
		                        	{
		                                this.addActionListener(e -> {
		                                	weights.setAttack_weight(weights.getAttack_weight()+1);
		                                	getAtkweight().setText("Atk: " + weights.getAttack_weight());
		                                }
		                                );
		                            }
		                        });  // DEF Plus Button
		                        this.add(new JButton("+") {
		                        	{
		                                this.addActionListener(e -> {
		                                	weights.setDefense_weight(weights.getDefense_weight()+1);
		                                	getDefweight().setText("Def: " + weights.getDefense_weight());
		                                }
		                                );
		                            }
		                        });  // HP Plus Button
		                        this.add(new JButton("+") {
		                        	{
		                                this.addActionListener(e -> {
		                                	weights.setSpAtk_weight(weights.getSpAtk_weight()+1);
		                                	getSpaweight().setText("SpA: " + weights.getSpAtk_weight());
		                                }
		                                );
		                            }
		                        });  // DEF Plus Button
		                        this.add(new JButton("+") {
		                        	{
		                                this.addActionListener(e -> {
		                                	weights.setSpDef_weight(weights.getSpDef_weight()+1);
		                                	getSpdweight().setText("SpD: " + weights.getSpDef_weight());
		                                }
		                                );
		                            }
		                        });  // HP Plus Button
		                        this.add(new JButton("+") {
		                        	{
		                                this.addActionListener(e -> {
		                                	weights.setSpeed_weight(weights.getSpeed_weight()+1);
		                                	getSpeweight().setText("Spe: " + weights.getSpeed_weight());
		                                }
		                                );
		                            }
		                        });  // DEF Plus Button
		                        if(!Objects.isNull(weights))
		                        {
		                        	
			                        this.add(getTimeWeight());
			                        this.add(getHPweight());
			                        this.add(getAtkweight());
			                        this.add(getDefweight());
			                        this.add(getSpaweight());
			                        this.add(getSpdweight());
			                        this.add(getSpeweight());
			                        
		                        }
		                        // Second row: "-" buttons
		                        this.add(new JButton("-") {
		                        	{
		                                this.addActionListener(e -> {
		                                	// if 0 stop
		                                	if(weights.getTime_weight() == 1)
		                                	{
		                                		return;
		                                	}
		                                	weights.setTime_weight(weights.getTime_weight()-1);
		                                	getTimeWeight().setText("Time: " + weights.getTime_weight());
		                                }
		                                );
		                            }
		                        });  // HP Minus Button
		                        this.add(new JButton("-") {
		                        	{
		                                this.addActionListener(e -> {
		                                	weights.setHP_weight(weights.getHP_weight()-1);
		                                	getHPweight().setText("HP: " + weights.getHP_weight());
		                                }
		                                );
		                            }
		                        });  // HP Minus Button
		                        this.add(new JButton("-") {
		                        	{
		                                this.addActionListener(e -> {
		                                	weights.setAttack_weight(weights.getAttack_weight()-1);
		                                	getAtkweight().setText("Atk: " + weights.getAttack_weight());
		                                }
		                                );
		                            }
		                        });  // DEF Minus Button
		                        
		                     // Second row: "-" buttons
		                        this.add(new JButton("-") {
		                        	{
		                                this.addActionListener(e -> {
		                                	weights.setDefense_weight(weights.getDefense_weight()-1);
		                                	getDefweight().setText("Def: " + weights.getDefense_weight());
		                                }
		                                );
		                            }
		                        });  // HP Minus Button
		                        this.add(new JButton("-") {
		                        	{
		                                this.addActionListener(e -> {
		                                	weights.setSpAtk_weight(weights.getSpAtk_weight()-1);
		                                	getSpaweight().setText("SpA: " + weights.getSpAtk_weight());
		                                }
		                                );
		                            }
		                        });  // DEF Minus Button
		                        
		                     // Second row: "-" buttons
		                        this.add(new JButton("-") {
		                        	{
		                                this.addActionListener(e -> {
		                                	weights.setSpDef_weight(weights.getSpDef_weight()-1);
		                                	getSpdweight().setText("SpD: " + weights.getSpDef_weight());
		                                }
		                                );
		                            }
		                        });  // HP Minus Button
		                        this.add(new JButton("-") {
		                        	{
		                                this.addActionListener(e -> {
		                                	weights.setSpeed_weight(weights.getSpeed_weight()-1);
		                                	getSpeweight().setText("Spe: " + weights.getSpeed_weight());
		                                }
		                                );
		                            }
		                        });  // DEF Minus Button
		                    }
		                }, BorderLayout.SOUTH); // Add the grid panel below the ComboBox
		        	}
		        }, BorderLayout.SOUTH);
		        
		        
		        
		    }
		}, BorderLayout.SOUTH);
	
	

	
	
	
	}
	
	public int getRunType()
	{
		return this.runType.getSelectedItem().toString().equals("Elite 4 Round 2 Score") ? 1 : 0;
	}
	
	public ScoreWeights getScoreWeights()
	{
		return this.weights;
	}
	public void setWeights(ScoreWeights weights)
	{
		this.weights = weights;
	}
	
	public JLabel getTimeWeight() {
		return timeWeight;
	}

	public void setTimeWeight(JLabel timeWeight) {
		this.timeWeight = timeWeight;
	}

	public JLabel getHPweight() {
		return HPweight;
	}

	public void setHPweight(JLabel hPweight) {
		HPweight = hPweight;
	}

	public JLabel getAtkweight() {
		return Atkweight;
	}

	public void setAtkweight(JLabel atkweight) {
		Atkweight = atkweight;
	}

	public JLabel getDefweight() {
		return Defweight;
	}

	public void setDefweight(JLabel defweight) {
		Defweight = defweight;
	}

	public JLabel getSpaweight() {
		return Spaweight;
	}

	public void setSpaweight(JLabel spaweight) {
		Spaweight = spaweight;
	}

	public JLabel getSpdweight() {
		return Spdweight;
	}

	public void setSpdweight(JLabel spdweight) {
		Spdweight = spdweight;
	}

	public JLabel getSpeweight() {
		return Speweight;
	}

	public void setSpeweight(JLabel speweight) {
		Speweight = speweight;
	}

	private JCheckBox[] chkNature;
	
	private MainWindow mw;
	private Controller c;
	private PokemonFoundPanel pkmFoundPanel;
	private Image BOXPANEL;
	private Pokemon selectedPokemon;
	private int selectedFrame;
	private JComboBox<String> runType;
	private ScoreWeights weights;
	
	private JLabel timeWeight;
	private JLabel HPweight;
	private JLabel Atkweight;
	private JLabel Defweight;
	private JLabel Spaweight;
	private JLabel Spdweight;
	private JLabel Speweight;
	
}
