package com.laioffer.tinnews.ui.home;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.repository.NewsRepository;

public class HomeViewModel extends ViewModel {

  private final NewsRepository repository;
  private final MutableLiveData<String> countryInput = new MutableLiveData<>();

  public HomeViewModel(@NonNull NewsRepository newsRepository) {
    this.repository = newsRepository;
  }

  public void setCountryInput(String country) {
    countryInput.setValue(country);
  }

  public LiveData<NewsResponse> getTopHeadlines() {
    return Transformations.switchMap(countryInput, repository::getTopHeadlines);
  }
}
