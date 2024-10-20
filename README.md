![squirtlescore](https://github.com/user-attachments/assets/d8991f7a-0d28-4e78-9cf6-672146648dab)# Pokemon-Gen3-IV-Predictor
Predict Gen 3 IV Predictor

1. Go to releases
https://github.com/rikardure/Pokemon-Gen3-IV-Predictor/releases

2. Select newest release

3. Download the .jar file

4. Run the .jar file

You probably need java installed on your machine to run it :)


# Scoring system.

Squirtles are rated between 30-100.

Squirtles below 45 are not worth running and only good for turtle soup. It felt wrong to have the lowest point be less than 30 when we already set requirements for 30 spa, 21 atk, 16 def and 21 spe.

Think of this as similar to Farenheit scale in terms of hot/cold or exam grading where below 45% is a failure.

* Bad but runnable 45-55

* Adequate 55-65

* Good 65-75

* Great 75-90

* Amazing 90+

If the difference between scores is <5, then prioritize the earlier squirtle if the time difference is more than 2s.

# Behind scoring

The later a squirtle arrives, the more punishment the score receives.

* (Current frame - 3900)/7, this will be subtracted from the "total"

* Rash Nature gives a few bonus points (150)

* HP * 11

* Def * 9

* Tankiness (HP * DEF)/4

* Atk * 5

* Spe * 5

* Spd * 1

Add these together for a total score and normalize it on a scale of 30-100

As a general rule: If the score difference is less than 5, choose the earlier one, except when the time difference is less than 2 seconds.

# Other

Saving will create a `preset.json` where the preset is stored. 


![squirtlescore](https://github.com/user-attachments/assets/10c75e0b-7241-439f-bd6f-725c69d99cd7)

Red highlights newly implemented features
