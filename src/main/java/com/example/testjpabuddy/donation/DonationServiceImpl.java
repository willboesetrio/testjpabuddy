package com.example.testjpabuddy.donation;

import com.example.testjpabuddy.account.AccountRepo;
import com.example.testjpabuddy.agency.AgencyRepo;
import com.example.testjpabuddy.donationItem.DonationItem;
import com.example.testjpabuddy.donationItem.DonationItemRepo;
import com.example.testjpabuddy.itemType.ItemTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class DonationServiceImpl implements DonationService{

    DonationRepo donationRepo;
    AccountRepo accountRepo;

    AgencyRepo agencyRepo;

    DonationItemRepo donationItemRepo;

    ItemTypeRepo itemTypeRepo;

    public DonationServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public List<Donation> getAllDonations() {
        return donationRepo.findAll();
    }

    @Override
    public Donation getDonationById(Long id) {
        return donationRepo.findDonationById(id);
    }

    @Override
    public List<Donation> getDonationsByAccountId(Long accountId) {
        return donationRepo.findByAccountId(accountId);
    }

    @Override
    public void postDonation(DonationDto donationDto) {
        //create and save donation object
        Donation currentDonation = new Donation();
        currentDonation.setAccount(accountRepo.getAccountById(donationDto.getAccountId()));
        currentDonation.setAgency(agencyRepo.getAgencyById(donationDto.getAgencyId()));
        currentDonation.setDonationDatetime(Instant.now());
        Donation savedDonation = donationRepo.save(currentDonation);
        //create and save donation item object
        DonationItem currentDonationItem = new DonationItem();
        currentDonationItem.setItemType(itemTypeRepo.getItemTypeById("$"));
        currentDonationItem.setDesc(donationDto.getDesc());
        currentDonationItem.setDollarValue(donationDto.getDollarValue());
        currentDonationItem.setDonation(savedDonation);
        donationItemRepo.save(currentDonationItem);

    }

    @Autowired
    public void setDonationRepo(DonationRepo donationRepo) {
        this.donationRepo = donationRepo;
    }
    @Autowired
    public void setAccountRepo(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
    @Autowired
    public void setAgencyRepo(AgencyRepo agencyRepo) {
        this.agencyRepo = agencyRepo;
    }
    @Autowired
    public void setDonationItemRepo(DonationItemRepo donationItemRepo) {
        this.donationItemRepo = donationItemRepo;
    }
    @Autowired
    public void setItemTypeRepo(ItemTypeRepo itemTypeRepo) {
        this.itemTypeRepo = itemTypeRepo;
    }
}
