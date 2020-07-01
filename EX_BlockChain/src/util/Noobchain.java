package util;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

import Block.Block;

public class Noobchain {
	
	public static ArrayList<Block> blockChain = new ArrayList<Block>();
	public static int difficulty = 5;
	
	public static Boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		for(int i = 1; i < blockChain.size(); i++) {
			currentBlock = blockChain.get(i);
			previousBlock = blockChain.get(i-1);
			if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("Current hashes not equal");
				return false;
			}
			if(!previousBlock.hash.equals(currentBlock.previousHash)) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			if(!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This Block hasn't been mined");
				return false;
			}

		}
		return true;
	}
	
	public static void main(String[] args) {
		blockChain.add(new Block("First BlockChain", "0"));
		System.out.println("첫번째 마인블럭 중...");
		blockChain.get(0).mineBlock(difficulty);
		
		blockChain.add(new Block("Second BlockChain", blockChain.get(blockChain.size()-1).hash));
		System.out.println("두번째 마인블럭 중...");
		blockChain.get(1).mineBlock(difficulty);
		
		blockChain.add(new Block("Third BlockChain", blockChain.get(blockChain.size()-1).hash));
		System.out.println("세번째 마인블럭 중...");
		blockChain.get(2).mineBlock(difficulty);
		
		System.out.println("\nBlockChain is valid: " + isChainValid());
		
		String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
		System.out.println("\nThe block Chain : ");
		System.out.println(blockChainJson);
	}
		
}
