package com.onsmarttech.invillia.repositories.store;

import java.util.List;

import com.onsmarttech.invillia.dao.StoreFilter;
import com.onsmarttech.invillia.entities.Store;

public interface StoreRepositoryCustom {

	List<Store> filter(StoreFilter filter);
}
