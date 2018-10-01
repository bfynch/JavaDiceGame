package view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import model.GameEngineImpl;

public class SaveFileChooser {

	public SaveFileChooser(GameEngineImpl ge)
	{
		JFileChooser chooser = new JFileChooser();
		    chooser.setCurrentDirectory(new File("/home/me/Documents"));
		    int retrival = chooser.showSaveDialog(null);
		    if (retrival == JFileChooser.APPROVE_OPTION) {
		        try {
		    		FileOutputStream fos = new FileOutputStream(chooser.getSelectedFile());
		    		ObjectOutputStream out = new ObjectOutputStream(fos);
		        	out.writeObject(ge.players);
		    		
		    		out.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}
	}

	

