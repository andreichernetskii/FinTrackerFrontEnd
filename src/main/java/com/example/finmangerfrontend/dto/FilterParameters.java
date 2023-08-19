package com.example.finmangerfrontend.dto;

// filter class for filtering on web-page
public class FilterParameters {
    private String year;
    private String month;
    private String operationType;
    private String category;

    public void setYear( String year ) {
        this.year = year;
    }

    public void setMonth( String month ) {
        this.month = month;
    }

    public void setOperationType( String operationType ) {
        this.operationType = operationType;
    }

    public void setCategory( String category ) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getCategory() {
        return category;
    }

    public String getParamsAsURL() {
        StringBuilder stringBuilder = new StringBuilder();
        if ( year != null && !year.isEmpty() ) stringBuilder.append( "year=" ).append( year ).append( "&" );
        if ( month != null && !month.isEmpty() ) stringBuilder.append( "month=" ).append( month ).append( "&" );
        if ( operationType != null ) stringBuilder.append( "operationType=" ).append( operationType ).append( "&" );
        if ( category != null ) stringBuilder.append( "category=" ).append( category ).append( "&" );
        return stringBuilder.toString();
    }
}
