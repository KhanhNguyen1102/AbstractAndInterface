package MiniTest;

import java.util.Scanner;

public class ProductManager {
    private static Product[] listProduct;

    public static void main(String[] args) {
        listProduct = createListProduct();
        input(listProduct);
        output(listProduct);
        totalPriceProduct(listProduct);
        findProduct(listProduct);
        editProduct(listProduct);
        deleteProduct(listProduct);
        output(listProduct);
    }

    public static void setListProduct(Product[] listProduct) {
        ProductManager.listProduct = listProduct;
    }

    //    Hàm tạo mảng Product
    public static Product[] createListProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử trong mảng Product :");
        int size = scanner.nextInt();
        return new Product[size];
    }

    //    Hàm điền phần tử cho mảng Product
    public static void input(Product[] listProduct) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < listProduct.length; i++) {
            System.out.println("Nhập vào code");
            int code = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhập vào tên ");
            String name = scanner.nextLine();
            System.out.println("Nhập vào giá ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Nhập vào thể loại ");
            String category = scanner.nextLine();
            Product product = new Product(code, name, price, category);
            listProduct[i] = product;
        }
    }

    //    Hàm in mảng Product
    public static void output(Product[] listProduct) {
        for (int i = 0; i < listProduct.length; i++) {
            System.out.println(listProduct[i]);
        }
    }

    //    Hàm tính tổng tiền các Product
    public static double totalPriceProduct(Product[] listProduct) {
        double totalprice = 0;
        for (int i = 0; i < listProduct.length; i++) {
            totalprice += listProduct[i].getPrice();
        }
        return totalprice;
    }
//    Hàm sửa sản phẩm theo code
    public static void findProduct(Product[] listProduct) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên Product muốn tìm ");
        String name = scanner.nextLine();
        for (int i = 0; i < listProduct.length; i++) {
            if (name.equals(listProduct[i].getName())) {
                System.out.println("Trong list có Product này. " + listProduct[i]);
                return;
            }
        }
        System.out.println("Trong list ko có Product này ");
    }
//    Hàm sửa sản phẩm theo mã
    public static void editProduct(Product[] listProduct){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào mã sản phẩm muốn sửa thông tin ");
        int code = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < listProduct.length; i++) {
            if(code == listProduct[i].getCode()){
                System.out.println("Bạn muốn đổi tên sản phẩm thành :");
                listProduct[i].setName(scanner.nextLine());
                System.out.println("Bạn muốn đổi giá sản phẩm thành ");
                listProduct[i].setPrice(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Bạn muốn đổi thể loại sản phẩm thành ");
                listProduct[i].setCategory(scanner.nextLine());
                System.out.println("Bạn muốn đổi mã sản phẩm thành ");
                listProduct[i].setCode(scanner.nextInt());
                System.out.println("Hiện tại sản phẩm có thông tin " + listProduct[i].toString());
            }else {
                System.out.println("Trong list ko có sản phẩm này");
            }
        }
    }
//    Hàm xóa sản phẩm theo mã
    public static void deleteProduct(Product[] listProduct){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào mã sản phẩm muốn xóa ");
        int code = scanner.nextInt();
        scanner.nextLine();
        Product[] listProduct1 = new Product[listProduct.length-1];
        int index = 0;
        for (int i = 0; i < listProduct.length; i++) {
            if (code == listProduct[i].getCode()){
                continue;
            }
            if (i == listProduct1.length-1){
                setListProduct(listProduct1);
                return;
            }
            listProduct1[index]=listProduct[i];
            index++;
        }
        setListProduct(listProduct1);

    }
}
