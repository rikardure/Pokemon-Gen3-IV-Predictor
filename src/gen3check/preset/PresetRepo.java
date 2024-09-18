package gen3check.preset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import gen3check.util.FileUtil;

public class PresetRepo {
	private static final String FULL_PATH =  FileUtil.SAVED_PRESET;
	private ObjectMapper mapper = new ObjectMapper();
	public void save(PresetDTO preset)
	{
		try (FileWriter writer = new FileWriter(FULL_PATH, false)) { 
            writer.write(mapper.writeValueAsString(preset));
        } catch (Exception e) {
        	throw new RuntimeException("failed to save preset to "+ FULL_PATH, e);
        }
		
		
	}
	
	public PresetDTO load() {
		try (BufferedReader reader = new BufferedReader(new FileReader(FULL_PATH))) {
            String json = reader.readLine();
            return mapper.readValue(json, PresetDTO.class);
        } catch (Exception e) {
        	throw new RuntimeException("failed to load preset from "+ FULL_PATH, e);
        }
	}
}
