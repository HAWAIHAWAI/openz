--\encoding ISO_8859_15
--\encoding UTF-8
copy zsi_bpartner from '/tmp/BPartner.csv' CSV DELIMITER as ';' HEADER ;

copy zsi_bp_contact from '/tmp/BP_Contact.csv' CSV DELIMITER as ';' HEADER ;

copy zsi_bp_location from '/tmp/BP_Location.csv' CSV DELIMITER as ';' HEADER ;

copy zsi_bp_customer from '/tmp/BP_Customer.csv' CSV DELIMITER as ';' HEADER ;

copy zsi_bp_bank from '/tmp/BP_Bank.csv' CSV DELIMITER as ';' HEADER ;

copy zsi_bp_vendor from '/tmp/BP_Vendor.csv' CSV DELIMITER as ';' HEADER ;





copy zsi_product from '/tmp/Product.csv' CSV DELIMITER as ';' HEADER ;

copy zsi_productbom from '/tmp/ProductBOM.csv' CSV DELIMITER as ';' HEADER ;

copy zsi_productpo from '/tmp/ProductPO.csv' CSV DELIMITER as ';' HEADER ;

copy zsi_productorg from '/tmp/ProductSTOCKPlanning.csv' CSV DELIMITER as ';' HEADER ;

--\encoding ISO_8859_15
copy zsi_productuom from '/tmp/ProductUOM.csv' CSV DELIMITER as ';' HEADER ;
--\encoding UTF-8

copy zsi_productprice from '/tmp/ProductPRICE.csv' CSV DELIMITER as ';' HEADER ;

copy zsi_producttrl from '/tmp/ProductTRL.csv' CSV DELIMITER as ';' HEADER ;


copy zsi_inventory from '/tmp/Inventory.csv' CSV DELIMITER as ';' HEADER ;

update  ZSI_BPARTNER  set isactive='Y' where isactive is null;
update  zsi_productbom  set isactive='Y' where isactive is null;
update  zsi_productpo  set isactive='Y' where isactive is null;
update  zsi_productprice  set isactive='Y' where isactive is null;
update  zsi_producttrl  set isactive='Y' where isactive is null;
update  zsi_bpartner  set isactive='Y' where isactive is null;
update  zsi_bp_contact  set isactive='Y' where isactive is null;
update  zsi_bp_location  set isactive='Y' where isactive is null;
update  zsi_bp_customer  set isactive='Y' where isactive is null;
update  zsi_bp_bank  set isactive='Y' where isactive is null;



update ZSI_BP_VENDOR set ISVENDOR='Y';
update ZSI_BP_CUSTOMER set ISCUSTOMER='Y';

update ZSI_BP_LOCATION set COUNTRY_KEY=upper(COUNTRY_KEY);

/* Hochtüdelchen raus
delete from zsi_bp_customer where bp_value_key like'%''%';
delete from zsi_bp_contact where bp_value_key like'%''%';
delete from zsi_bp_bank where bp_value_key like'%''%';
delete from zsi_bp_location where bp_value_key like'%''%';
*/