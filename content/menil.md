
# Menil

```diagram:mermaid

flowchart LR
 A[Shopify] --> B[Integrator]
 B --> C[NetSuite]

 %% Main data categories
 subgraph DataCategories[Data Categories]
 direction TB
 Cat1[Customer Data] 
 Cat2[Product & Catalog]
 Cat3[Pricing & Discounts]
 Cat4[Inventory Management]
 Cat5[Orders & Transactions]
 Cat6[Shipping & Fulfillment]
 Cat7[Payment & Invoicing]
 Cat8[B2B Specific Data]
 Cat9[Metadata & Tags]
 end

 A --> DataCategories
 DataCategories --> B

 %% Customer Data Details
 subgraph CustomerData[Customer Data]
 direction TB
 A1[Customer Name]
 A2[Customer Email]
 A3[Customer Phone]
 A4[Billing Address]
 A5[Shipping Address]
 A6[Customer Type]
 A7[Customer Tags]
 A8[Account ID]
 A9[Customer Group]
 end

 %% Product & Catalog Details
 subgraph ProductCatalog[Product & Catalog]
 direction TB
 P1[Product Name]
 P2[Product SKU]
 P3[Description]
 P4[Type]
 P5[Category]
 P6[Images]
 P7[Pricing]
 P8[Availability]
 P9[Variants]
 P10[Barcode/UPC]
 P11[Vendor Info]
 end

 %% Pricing & Discounts Details
 subgraph PricingDiscounts[Pricing & Discounts]
 direction TB
 D1[B2B Price Levels]
 D2[CLIPA -32.31%]
 D3[Employee -61.54%]
 D4[Retail No Discount]
 D5[Volume 1 -30.77%]
 D6[Volume 2 -38.46%]
 D7[Volume 3 -41.54%]
 D8[Volume 4 -44.62%]
 D9[Volume 5 -46.16%]
 D10[Wholesale -23.08%]
 D11[Case Pack Pricing]
 D12[Case Pack Size]
 D13[Pack Specific Pricing]
 D14[Case Pack SKU]
 D15[MOQ]
 D16[Customer Pricing]
 D17[Volume Discounts]
 D18[Wholesale Visibility]
 D19[NetSuite Mapping]
 end

 %% Inventory Management Details
 subgraph InventoryMgmt[Inventory Management]
 direction TB
 I1[Stock Levels]
 I2[Backorder Status]
 I3[Low Stock Alerts]
 I4[Restock Dates]
 I5[Committed Stock]
 end

 %% Orders & Transactions Details
 subgraph OrdersTrans[Orders & Transactions]
 direction TB
 O1[Order ID]
 O2[Order Status]
 O3[Order Total]
 O4[Order Subtotal]
 O5[Taxes]
 O6[Discounts Applied]
 O7[Shipping Charges]
 O8[Payment Status]
 O9[Payment Method]
 O10[Fulfillment Status]
 O11[Tracking Number]
 O12[NetSuite Order ID]
 end

 %% Shipping & Fulfillment Details
 subgraph ShippingFulfill[Shipping & Fulfillment]
 direction TB
 S1[Shipping Method]
 S2[Shipping Carrier]
 S3[Est. Delivery Date]
 S4[Tracking Number]
 S5[Fulfillment Center]
 end

 %% Payment & Invoicing Details
 subgraph PaymentInvoice[Payment & Invoicing]
 direction TB
 PM1[Payment Gateway]
 PM2[Payment Status]
 PM3[NetSuite Invoice ID]
 PM4[Refund Information]
 end

 %% B2B Specific Data Details
 subgraph B2BData[B2B Specific Data]
 direction TB
 BB1[Company Name]
 BB2[Account Manager]
 BB3[Credit Terms]
 BB4[Custom Pricing]
 BB5[Catalog Access Rules]
 end

 %% Metadata & Tags Details
 subgraph MetadataTags[Metadata & Tags]
 direction TB
 M1[Custom Fields]
 M2[Product Tags]
 M3[Order Notes]
 end

 %% Connect categories to their details
 Cat1 ~~~ CustomerData
 Cat2 ~~~ ProductCatalog
 Cat3 ~~~ PricingDiscounts
 Cat4 ~~~ InventoryMgmt
 Cat5 ~~~ OrdersTrans
 Cat6 ~~~ ShippingFulfill
 Cat7 ~~~ PaymentInvoice
 Cat8 ~~~ B2BData
 Cat9 ~~~ MetadataTags
 
 ```