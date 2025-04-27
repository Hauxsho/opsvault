package com.dev.OpsVault.controllers;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.OpsVault.models.response.caseService.caseDetails.CaseResponse;
import com.dev.OpsVault.services.contract.CaseService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/case")
public class CaseController
{
	private CaseService caseService;

	@PostMapping
	@PreAuthorize("Admin")
	public ResponseEntity<CaseResponse> getListOfCases()
	{
		CaseResponse caseResponse = caseService.getListOfCases();
		return ResponseEntity.ok(caseResponse);
	}
}
