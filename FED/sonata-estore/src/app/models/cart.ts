import { Product } from "./product";

export class Cart {
    prod_id !: number;
    prod_name !: string;
    prod_category !: string;
    prod_description !: string;
    prod_price : string;
    prod_image !: string;
    prod_color !: string;
    qty!:number;

    constructor(prod_id:number,product:Product,qty=1){
        this.prod_id = prod_id;
        this.prod_name = product.prod_name;
        this.prod_category = product.prod_category;
        this.prod_description = product.prod_description;
        this.prod_price = product.prod_price;
        this.prod_image = product.prod_image;
        this.prod_color = product.prod_color;
        this.qty=qty;
    }
}
