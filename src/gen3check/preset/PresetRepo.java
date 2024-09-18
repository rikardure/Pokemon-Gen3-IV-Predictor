package gen3check.preset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import gen3check.util.FileUtil;

public class PresetRepo {
	
	private ObjectMapper mapper = new ObjectMapper();
	public void save(PresetDTO preset)
	{
		try (FileWriter writer = new FileWriter(FileUtil.SAVED_PRESET, false)) { 
            writer.write(mapper.writeValueAsString(preset));
        } catch (Exception e) {
        	throw new RuntimeException("failed to save preset to "+ FileUtil.SAVED_PRESET, e);
        }
		
		
	}
	
	public PresetDTO load() {
		try (BufferedReader reader = new BufferedReader(new FileReader(FileUtil.SAVED_PRESET))) {
            String json = reader.readLine();
            return mapper.readValue(json, PresetDTO.class);
        } catch (Exception e) {
        	throw new RuntimeException("failed to load preset from "+ FileUtil.SAVED_PRESET, e);
        }
	}
}
