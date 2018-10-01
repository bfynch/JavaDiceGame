package view;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.Player;

public class LoadFileChooser implements Serializable {
	
	public LoadFileChooser(DicePanel dp, GameEngineImpl ge) throws Exception {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) 
			{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				@SuppressWarnings("unchecked")
				ArrayList<Player> players = (ArrayList<Player>) in.readObject();
				in.close();
			
			for(Player player: players)
				{
				ge.players.add(player);
				dp.model.addElement((SimplePlayer) player);
				}
			}
		}	
	}
