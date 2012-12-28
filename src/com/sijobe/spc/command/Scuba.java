package com.sijobe.spc.command;

<<<<<<< HEAD
import java.util.HashMap;
=======
>>>>>>> upstream/master
import java.util.List;

import com.sijobe.spc.core.IPlayerMP;
import com.sijobe.spc.util.FontColour;
<<<<<<< HEAD
=======
import com.sijobe.spc.util.Settings;
import com.sijobe.spc.validation.Parameters;
>>>>>>> upstream/master
import com.sijobe.spc.wrapper.CommandException;
import com.sijobe.spc.wrapper.CommandSender;
import com.sijobe.spc.wrapper.Player;

/**
 * Allows the player to breath under water without restrictions
 *
 * @author simo_415
 * @version 1.0
 */
@Command (
   name = "scuba",
   description = "Allows the player to breath underwater",
   videoURL = "http://www.youtube.com/watch?v=1PO6BwUS2uo",
   version = "1.4.6"
)
public class Scuba extends StandardCommand implements IPlayerMP {

   /**
    * The integer value that specifies max player air
    */
   private static final int MAX_AIR = 300;
<<<<<<< HEAD
   
   /**
    * A hashmap containing path settings for each player
    */
   private static HashMap<String, Boolean> config = new HashMap<String, Boolean>();
   
   @Override
   public void execute(CommandSender sender, List<?> params) throws CommandException {
      Player player = super.getSenderAsPlayer(sender);
      Boolean value = config.get(player.getPlayerName());
      if (value == null || !value) {
         config.put(player.getPlayerName(), true);
         player.sendChatMessage("Scuba mode is " + FontColour.AQUA + "enabled");
      } else {
         config.put(player.getPlayerName(), false);
         player.sendChatMessage("Scuba mode is " + FontColour.AQUA + "disabled");
      }
=======

   @Override
   public void execute(CommandSender sender, List<?> params) throws CommandException {
      Player player = super.getSenderAsPlayer(sender);
      Settings config = super.loadSettings(player);
      boolean value = config.getBoolean("scuba", false);
      if (params.size() > 0) {
         value = !(Boolean)params.get(0);
      }
      if (!value) {
         config.set("scuba", true);
         player.sendChatMessage("Scuba mode is " + FontColour.AQUA + "enabled");
      } else {
         config.set("scuba", false);
         player.sendChatMessage("Scuba mode is " + FontColour.AQUA + "disabled");
      }
      config.save();
>>>>>>> upstream/master
   }
   
   /**
    * @see com.sijobe.spc.core.IPlayerMP#onTick(com.sijobe.spc.wrapper.Player)
    */
   @Override
   public void onTick(Player player) {
<<<<<<< HEAD
      String playerName = player.getPlayerName();
      if (config.containsKey(playerName)) {
         if (config.get(playerName)) {
            player.setAir(MAX_AIR);
         }
=======
      if (super.loadSettings(player).getBoolean("scuba", false)) {
         player.setAir(MAX_AIR);
>>>>>>> upstream/master
      }
   }

   /**
    * @see com.sijobe.spc.core.IHook#init(java.lang.Object[])
    */
   @Override
   public void init(Object... params) {
   }
<<<<<<< HEAD
=======
   
   @Override
   public Parameters getParameters() {
      return Parameters.DEFAULT_BOOLEAN;
   }
>>>>>>> upstream/master
}
