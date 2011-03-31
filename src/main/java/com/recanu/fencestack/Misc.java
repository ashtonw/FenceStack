package com.recanu.fencestack;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.bukkit.plugin.java.JavaPlugin;

public class Misc 
{
	
	public static String brackets(String s)
	{
		return "[" + s + "]";
	}
	public static String string(int i)
	{
		return String.valueOf(i);
	}
	public static String string(TreeType tr)
	{
		if (tr == TreeType.TREE)
			return "Tree";
		else if (tr == TreeType.BIG_TREE)
			return "Big Tree";
		else if (tr == TreeType.BIRCH)
			return "Birch";
		else if (tr == TreeType.REDWOOD)
			return "Redwood";
		else if (tr == TreeType.TALL_REDWOOD)
			return "Big Redwood";
		
		return "";
		
		
	}
	public static TreeType treeType(String s)
	{
		if (s.equalsIgnoreCase("tree"))
			return TreeType.TREE;
		else if (s.equalsIgnoreCase("bigtree"))
			return TreeType.BIG_TREE;
		else if (s.equalsIgnoreCase("birch"))
			return TreeType.BIRCH;
		else if (s.equalsIgnoreCase("redwood"))
			return TreeType.REDWOOD;
		else if (s.equalsIgnoreCase("bigredwood"))
			return TreeType.TALL_REDWOOD;
		
		return null;
	}
	public static IgniteCause igniteCause(String s)
	{
		if (s.equalsIgnoreCase("lava"))
			return IgniteCause.LAVA;
		else if (s.equalsIgnoreCase("flintandsteel"))
			return IgniteCause.FLINT_AND_STEEL;
		else if (s.equalsIgnoreCase("spread"))
			return IgniteCause.SPREAD;
		else 
			return null;
	}
	public static int integer(String s)
	{
		try
		{
			return Integer.parseInt(s);
		}
		catch (NumberFormatException n) 
		{
				return Integer.MIN_VALUE;
		}
	}
	public static String capitalize(String s)
	{
		String firstLetter = s.substring(0, 1);
		firstLetter = firstLetter.toUpperCase();
		String rest = s.substring(1, s.length());
		rest = rest.toLowerCase();
		return firstLetter + rest;
	}
	public static void showHelp(Player player, String cmd)
	{
		
		
	}
	
	
	public static void showConfig(Player player)
	{

		
		
	}
	
	public static Location add(Location loc, int x, int y, int z)
	{
		return new Location(loc.getWorld(), loc.getX() + x, loc.getY() + y, loc.getZ() + z);
	}
	public static Location substract(Location loc, int x, int y, int z)
	{
		return new Location(loc.getWorld(), loc.getX() - x, loc.getY() - y, loc.getZ() - z);
	}
	
	
	public static Location add(Location loc, double x, double y, double z)
	{
		return new Location(loc.getWorld(), loc.getX() + x, loc.getY() + y, loc.getZ() + z);
	}
	public static Location substract(Location loc, double x, double y, double z)
	{
		return new Location(loc.getWorld(), loc.getX() - x, loc.getY() - y, loc.getZ() - z);
	}
	
	public static double distance(Location loc1, Location loc2)
	{
		return Math.sqrt(Math.pow(loc1.getBlockX() - loc2.getBlockX(), 2) +
                Math.pow(loc1.getBlockY() - loc2.getBlockY(), 2) +
                Math.pow(loc1.getBlockZ() - loc2.getBlockZ(), 2));
	}
	
	public static boolean isInteger(String input)  
	{  
	    try  
	    {  
	       Integer.parseInt( input );  
	       return true;  
	    }  
		catch (NumberFormatException n) 
		{
				return false;
		}
	}  
    public static void broadcast(JavaPlugin instance, String message) 
    {
    	instance.getServer().broadcastMessage(message);
    }
	
	
	
	
    public static final String CRLF="\015\012";
    public static final String __LINE_SEPARATOR=
        System.getProperty("line.separator","\n");
    
    public static String __ISO_8859_1;
    static
    {
        String iso=System.getProperty("ISO_8859_1");
        if (iso!=null)
            __ISO_8859_1=iso;
        else
        {
            try{
                new String(new byte[]{(byte)20},"ISO-8859-1");
                __ISO_8859_1="ISO-8859-1";
            }
            catch(java.io.UnsupportedEncodingException e)
            {
                __ISO_8859_1="ISO8859_1";
            }        
        }
    }
    
    public final static String __UTF8="UTF-8";
    
    
    private static char[] lowercases = {
          '\000','\001','\002','\003','\004','\005','\006','\007',
          '\010','\011','\012','\013','\014','\015','\016','\017',
          '\020','\021','\022','\023','\024','\025','\026','\027',
          '\030','\031','\032','\033','\034','\035','\036','\037',
          '\040','\041','\042','\043','\044','\045','\046','\047',
          '\050','\051','\052','\053','\054','\055','\056','\057',
          '\060','\061','\062','\063','\064','\065','\066','\067',
          '\070','\071','\072','\073','\074','\075','\076','\077',
          '\100','\141','\142','\143','\144','\145','\146','\147',
          '\150','\151','\152','\153','\154','\155','\156','\157',
          '\160','\161','\162','\163','\164','\165','\166','\167',
          '\170','\171','\172','\133','\134','\135','\136','\137',
          '\140','\141','\142','\143','\144','\145','\146','\147',
          '\150','\151','\152','\153','\154','\155','\156','\157',
          '\160','\161','\162','\163','\164','\165','\166','\167',
          '\170','\171','\172','\173','\174','\175','\176','\177' };

    /* ------------------------------------------------------------ */
    public static boolean startsWithIgnoreCase(String s,String w)
    {
        if (w==null)
            return true;
        
        if (s==null || s.length()<w.length())
            return false;
        
        for (int i=0;i<w.length();i++)
        {
            char c1=s.charAt(i);
            char c2=w.charAt(i);
            if (c1!=c2)
            {
                if (c1<=127)
                    c1=lowercases[c1];
                if (c2<=127)
                    c2=lowercases[c2];
                if (c1!=c2)
                    return false;
            }
        }
        return true;
    }
    
    public static boolean canPassThrough(int id)
    {
    	return id == 0 // Air 
        || id == 8 // Water
        || id == 9 // Water
        || id == 10 // Lava
        || id == 11 // Lava
        || id == 51 // Fire
        || id == 78 // Snow
        || id == 6 // Sapling
        || id == 37 // Flower
        || id == 38 // Rose
        || id == 39 // Brown Mushroom
        || id == 40 // Red Mushroom
        || id == 50 // Torch
        || id == 55 // Wire
        || id == 63 // Sign
        || id == 65 // Ladder
        || id == 66 // Track
        || id == 68 // Wallsign
        || id == 70 // StonePressurePlate
        || id == 72 // WoodPressurePlate
        || id == 69 // Lever
        || id == 77 // Stone button
        || id == 75 // Redstone Torch off
        || id == 76 // Redstone Torch on
        || id == 90; // Portal
    }
    
    public static TreeType randomTreeType()
    {
    	int r = new Random().nextInt(100) + 1;
    	
    	if (r <= 65) // 65% chance of a normal Tree
    	{
    		return TreeType.TREE;
    	}
    	else if (r > 65  && r <= 90) // 25% chance for a birch
    	{
    		return TreeType.BIRCH;
    	}
    	else if (r > 90 && r <= 100) // 25% chance for a big tree
    	{
    		return TreeType.BIG_TREE;
    	}
    	return null;
    }
    
    public static boolean blockBeneathEquals(Block b, Material m)
    {
    	World world = b.getWorld();
    	if (world.getBlockAt(b.getX(), b.getY() - 1, b.getZ()).getType() == m)
    		return true;
    	
    	return false;
    }

	public static boolean isReplacableBlock(int id)
	{
		return id == 0 // Air 
        || id == 8 // Water
        || id == 9 // Water
        || id == 10 // Lava
        || id == 11 // Lava
        || id == 51 // Fire
        || id == 78; // Snow
	}
	public static boolean isPlacableBlock(int id)
	{
		return (id < 92 && id != 0)
		|| id == 323 // Sign
		|| id == 331 // Redstone
		|| id == 354 // Cake
		|| id == 326 // Water Bucket
		|| id == 327 // Lava Bucket
		|| id == 259 // Flint and Steel
		|| id == 324 // Wood Door
		|| id == 330 // Iron Door
		|| id == 295 // Seeds
		|| id == 338; // Sugar Cane
	}
	
	public static boolean isAttachable(int id)
	{
		return id == 50 // Torch
		|| id == 63 // Sign Post
		|| id == 65 // Ladder
		|| id == 68 // Wall Sign
		|| id == 69 // Lever
		|| id == 75 // Redstone torch off
		|| id == 76 // Redstone torch on
		|| id == 77 // Stone Button
		|| id == 323; // Sign
		
	}
}
	
