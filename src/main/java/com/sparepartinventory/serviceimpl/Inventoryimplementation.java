package com.sparepartinventory.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparepartinventory.entity.Inventory;

import com.sparepartinventory.repo.InventoryRepository;

@Service
public class Inventoryimplementation {

	@Autowired
	private InventoryRepository repo;

	// create and update
	public boolean createSpareparts(Inventory inventory) {

		Inventory save = repo.save(inventory);
		if (save != null)
			return true;

		else
			return false;

	}

	public boolean updateSpareParts(Inventory inventory) {
		Inventory findById = repo.findById(inventory.getPartNumber()).get();
//		Inventory inventory2 = byId.get();
		boolean b = false;
		if (findById != null) {
			repo.save(inventory);
			b = true;
		}
		return b;
	}

	public List<Inventory> getSpareparts() {
		List<Inventory> findAll = repo.findAll();
		if (findAll != null)
			return findAll;
		else
			return null;
	}

	public Inventory getById(Long partNumber) {

		Optional<Inventory> findById = repo.findById(partNumber);
		Inventory inventory = findById.get();
		return inventory;

	}

	public boolean deleteSpareparts(Long partNumber) {

		Optional<Inventory> findById = repo.findById(partNumber);
		if (findById != null) {
			repo.deleteById(partNumber);
			return true;
		} else {
			return false;
		}

	}

	public List<Inventory> getTop5() {
		List<Inventory> topFiveSpareparts = repo.getTopFiveSpareparts();
		System.out.println(topFiveSpareparts);
		return topFiveSpareparts;
	}

	public List<Inventory> getLastThree() {
		List<Inventory> leastThreeSpareparts = repo.getLeastThreeSpareparts();
		return leastThreeSpareparts;
	}

}
