package com.test.service;

import java.util.List;

import com.test.dto.Vendor;

public interface VendorService {
	List<Vendor> selectVendorsList(String viName);
}
