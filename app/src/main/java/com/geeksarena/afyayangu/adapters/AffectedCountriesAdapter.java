package com.geeksarena.afyayangu.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geeksarena.afyayangu.R;
import com.geeksarena.afyayangu.interfaces.CountryClickListener;
import com.geeksarena.afyayangu.models.Country;

import java.util.List;

public class AffectedCountriesAdapter extends RecyclerView.Adapter<AffectedCountriesAdapter.CountryViewHolder> {

    private List<Country> countryList;
    private CountryClickListener countryClickListener;

    public AffectedCountriesAdapter(List<Country> countryList, CountryClickListener countryClickListener) {
        this.countryList = countryList;
        this.countryClickListener = countryClickListener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_row, parent, false);
        return new CountryViewHolder(view, countryClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.country.setText("Country : "+countryList.get(position).getCountry());
        holder.slug.setText("Slug : "+countryList.get(position).getSlug());
        holder.iSO2.setText("ISO2 : "+ countryList.get(position).getISO2());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        private TextView country;
        private TextView slug;
        private TextView iSO2;
        private CountryClickListener countryClickListener;


        public CountryViewHolder(@NonNull View itemView, CountryClickListener countryClickListener) {
            super(itemView);
            country = itemView.findViewById(R.id.country_name);
            slug = itemView.findViewById(R.id.slug);
            iSO2 = itemView.findViewById(R.id.iso);
            this.countryClickListener = countryClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            countryClickListener.onCountryClick(countryList.get(getAdapterPosition()));

        }
    }
}
