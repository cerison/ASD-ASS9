package miu.cs.ads_datapersisitence.dto.response;

public record UserAuthResponse(
        String jwtToken,
        String firstName,
        String lastName
) {
}
