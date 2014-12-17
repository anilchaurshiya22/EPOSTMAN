package edu.mum.waa.epostman.domain;

import java.util.ArrayList;
import java.util.List;

public enum ItemType {
	
	 Pickable("pickable", 0), NonPickable("nonPickable", 1);

		private String name;
		private int value;

		private ItemType(String name, int value) {
			this.name = name;
			this.value = value;

		}

		public static List<ItemType> getAllItemType() {
			List<ItemType> itemTypes = new ArrayList<ItemType>();
			for (ItemType itemType : ItemType.values()) {
				itemTypes.add(itemType);
			}
			return itemTypes;
		}
		
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		public int getValue() {
			return value;
		}

}
