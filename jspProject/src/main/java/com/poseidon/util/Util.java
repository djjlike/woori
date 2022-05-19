package com.poseidon.util;

public class Util {
	public static boolean str2Int(String str) {
	      try {
	         Integer.parseInt(str);
	         return true;
	      } catch(NumberFormatException e) {
	         return false;
	      }
	   }
}
