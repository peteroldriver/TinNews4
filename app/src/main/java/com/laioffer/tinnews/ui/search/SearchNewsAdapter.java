package com.laioffer.tinnews.ui.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.databinding.SearchNewsItemBinding;
import com.laioffer.tinnews.model.Article;

import java.util.ArrayList;
import java.util.List;

public class SearchNewsAdapter extends RecyclerView.Adapter<SearchNewsAdapter.SearchNewsViewHolder> {

  // 1. Supporting data:
  private List<Article> articles = new ArrayList<>();

  public void setArticles(List<Article> newsList) {
    articles.clear();
    articles.addAll(newsList);
    notifyDataSetChanged();
  }

  // 2. SearchNewsViewHolder:
  public static class SearchNewsViewHolder extends RecyclerView.ViewHolder {

    ImageView itemImageView;
    TextView itemTitleTextView;

    public SearchNewsViewHolder(@NonNull View itemView) {
      super(itemView);
      SearchNewsItemBinding binding = SearchNewsItemBinding.bind(itemView);
      itemImageView = binding.searchItemImage;
      itemTitleTextView = binding.searchItemTitle;
    }
  }

  // 3. Adapter overrides:
  @NonNull
  @Override
  public SearchNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_news_item, parent, false);
    return new SearchNewsViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull SearchNewsViewHolder holder, int position) {
    Article article = articles.get(position);
    holder.itemTitleTextView.setText(article.title);
  }

  @Override
  public int getItemCount() {
    return articles.size();
  }
}
