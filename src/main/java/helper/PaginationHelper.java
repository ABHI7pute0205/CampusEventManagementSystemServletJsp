package helper;

public class PaginationHelper {

    public static int getOffset(int page, int recordsPerPage) {
        return (page - 1) * recordsPerPage;
    }

    public static int getTotalPages(int totalRecords, int recordsPerPage) {
        return (int) Math.ceil((double) totalRecords / recordsPerPage);
    }
}
